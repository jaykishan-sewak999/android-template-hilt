# android-template-hilt

---

# Android MVVM Template

This is a template Android project that follows the MVVM (Model-View-ViewModel) architecture pattern. It includes Dagger Hilt for dependency injection and Kotlin Coroutines for asynchronous programming.

## Features

- **MVVM Architecture**: Separation of concerns with clear division of responsibilities between the View, ViewModel, and Model layers.
- **Dagger Hilt**: Dependency injection framework for Android that reduces boilerplate code.
- **Kotlin Coroutines**: For asynchronous and non-blocking programming.
- **LiveData**: Lifecycle-aware observable data holder class.
- **Repository Pattern**: Centralized data source for handling data operations.
- **ViewBinding**: Type-safe way of accessing views in Android.
- **Navigation Component**: For handling navigation between fragments.
- **Unit Testing**: Basic setup for unit testing ViewModel and Repository classes.

## Installation

Clone the repository:

```
git clone https://github.com/jaykishan-sewak999/android-template-hilt
```

## Usage

1. Open the project in Android Studio.
2. Build the project to ensure all dependencies are resolved.
3. Start building your app on top of this template.

## Dependencies

- [Kotlin](https://kotlinlang.org/)
- [Dagger Hilt](https://dagger.dev/hilt/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
    - [Room](https://developer.android.com/topic/libraries/architecture/room)
    - [Navigation Component](https://developer.android.com/guide/navigation)
- [JUnit](https://junit.org/junit5/)
- [Mockito](https://site.mockito.org/)

## Structure

```
|-- app
    |-- src
        |-- main
            |-- java/com/example/yourproject/
                |-- data/
                |-- di/
                |-- ui/
                |-- util/
            |-- res/
        |-- test
            |-- java/com/example/yourproject/
                |-- data/
                |-- ui/
                |-- util/
```

- **data/**: Contains data sources, repository, and data models.
- **di/**: Dependency injection setup using Dagger Hilt.
- **ui/**: Contains UI components, including activities, fragments, and view models.
- **util/**: Utility classes.

## Contributing

Feel free to contribute to this project by opening issues or pull requests. Contributions are welcome!
