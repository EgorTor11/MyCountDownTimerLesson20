package com.example.mycountdowntimerlesson20

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    val numberList = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

    val liveData = MutableLiveData<String>()

    val liveDataBool = MutableLiveData<Boolean>()
    val liveDataBoolToastUCCHS = MutableLiveData<Boolean>()
    val liveDataBoolToastVibroSbros = MutableLiveData<Boolean>()

    lateinit var countDownTimer: CountDownTimer

    fun startTimer(timeSecond: Long) {

        countDownTimer = object : CountDownTimer(timeSecond * 1000 + 1000, 1) {
            override fun onTick(millisUntilFinished: Long) {

                liveData.value = (millisUntilFinished / 1000).toString()

            }

            override fun onFinish() {
                liveData.value = "0"

                liveDataBool.value = true

            }

        }.start()


    }

    fun sbrosTimer() {
        countDownTimer.cancel()
        liveData.value = "0"
    }

    fun onStartTimerClick(edText: String) {
        var str = "0"
        for (it in edText.toString().trim()) {
            if (!numberList.contains(it.toString())) {
                liveDataBoolToastUCCHS.value = true
                // Toast.makeText(this, "укажите целое число секунд", Toast.LENGTH_LONG).show()
                str = "0"
                break
            } else {
                str = edText.toString().trim()
            }
        }

        if (liveData.value == null || liveData.value == "0") {
            if (str != "0") {
                startTimer(str.toLong())//
            } else {
                liveDataBoolToastUCCHS.value = true
                //Toast.makeText(this, "укажите целое число секунд", Toast.LENGTH_LONG).show()
            }
        } else {
            sbrosTimer()
            liveDataBoolToastVibroSbros.value = true
            // Toast.makeText(getApplication(), "Таймер сброшен", Toast.LENGTH_LONG).show()
            // vibro(this)
        }
    }
}