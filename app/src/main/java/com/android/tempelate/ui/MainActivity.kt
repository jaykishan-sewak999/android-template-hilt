package com.android.tempelate.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.tempelate.R
import com.android.tempelate.databinding.ActivityMainBinding
import com.android.tempelate.ui.multiapi.MultipleAPICallActivity
import com.android.tempelate.ui.parallelapi.ParallelAPICallActivity
import com.android.tempelate.ui.singleapi.SingleAPICallActivity

class MainActivity : AppCompatActivity() {

    private var dataBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding?.btnOpenSingleApi?.setOnClickListener {
            startActivity(Intent(this@MainActivity,SingleAPICallActivity::class.java))
        }

        dataBinding?.btnMultiSingleApi?.setOnClickListener {
            startActivity(Intent(this@MainActivity,MultipleAPICallActivity::class.java))
        }

        dataBinding?.btnMultiParallelApi?.setOnClickListener {
            startActivity(Intent(this@MainActivity,ParallelAPICallActivity::class.java))
        }
    }
}