package com.meli.shop.designsystem.utils

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

fun Context.performHapticFeedback() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager =
            getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator.vibrate(
            VibrationEffect.createOneShot(
                VIBRATE_TIME,
                VIBRATE_AMPLITUDE
            )
        )
    } else {
        @Suppress("DEPRECATION")
        (getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(VIBRATE_TIME)
    }
}

private const val VIBRATE_TIME: Long = 300
private const val VIBRATE_AMPLITUDE: Int = 10
