package com.example.mycountdowntimerlesson20

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

fun vibro(context: Context) {
    // Kotlin
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    val canVibrate: Boolean = vibrator.hasVibrator()
    val milliseconds = 1000L

    if (canVibrate) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // API 26
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    milliseconds,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            // This method was deprecated in API level 26
            vibrator.vibrate(milliseconds)
        }
    }
}