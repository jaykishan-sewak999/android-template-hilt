package com.android.tempelate.ui.parallelapi

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.android.tempelate.R
import com.android.tempelate.adapter.CricketerAdapter
import com.android.tempelate.databinding.ActivityParallelApiCallBinding
import com.android.tempelate.model.User
import com.android.tempelate.util.Status
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParallelAPICallActivity : AppCompatActivity() {

    private var dataBinding: ActivityParallelApiCallBinding? = null
    private var adapter: CricketerAdapter?= null
    private val viewModel : ParallelAPICallViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_parallel_api_call)
        initViews()
        registerObserver()
    }

    private fun initViews() {
        dataBinding?.rvUsers?.layoutManager = LinearLayoutManager(this)
        dataBinding?.rvUsers?.setHasFixedSize(true)
        dataBinding?.rvUsers?.addItemDecoration(
            DividerItemDecoration(
                this,
                (dataBinding?.rvUsers?.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun registerObserver() {
        viewModel.playersList.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    dataBinding?.progressCircular?.visibility = View.VISIBLE
                    dataBinding?.rvUsers?.visibility = View.GONE
                }

                Status.ERROR -> {
                    dataBinding?.progressCircular?.visibility = View.GONE
                    dataBinding?.rvUsers?.visibility = View.GONE
                    val snack = dataBinding?.let { it1 -> it?.message?.let { error ->
                        Snackbar.make(it1.root,
                            error,Snackbar.LENGTH_LONG)
                    } }
                    snack?.show()
                }

                Status.SUCCESS -> {
                    dataBinding?.progressCircular?.visibility = View.GONE
                    dataBinding?.rvUsers?.visibility = View.VISIBLE
                    it.data?.let { it1 -> setRecyclerData(it1) }
                }
            }
        }
    }

    private fun setRecyclerData(data: List<User>) {
        adapter = CricketerAdapter(data)
        dataBinding?.rvUsers?.adapter = adapter
    }
}