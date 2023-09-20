package com.example.demo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp(Application::class)
class DemoApplication : Hilt_DemoApplication()
