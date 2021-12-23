package com.example.mycountdowntimerlesson20

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application): AndroidViewModel(application) {


    val liveData=MutableLiveData<String>()
lateinit var countDownTimer:CountDownTimer

    fun startTimer(p0:Long){
     countDownTimer= object : CountDownTimer(p0*1000+1000,1){
            override fun onTick(millisUntilFinished: Long) {
             //   binding.tvCount.text = (millisUntilFinished/1000).toString()
                liveData.value=(millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                liveData.value="0"
Toast.makeText(getApplication(),"Finish",Toast.LENGTH_LONG).show()
vibro(getApplication())
            }

        }.start()

    }

}