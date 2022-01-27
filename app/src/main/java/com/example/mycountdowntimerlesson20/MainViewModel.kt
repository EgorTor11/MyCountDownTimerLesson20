package com.example.mycountdowntimerlesson20

import android.app.Application
import android.opengl.Visibility
import android.os.CountDownTimer
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {


    val liveData=MutableLiveData<String>()

    val liveDataBool=MutableLiveData<Boolean>()

lateinit var countDownTimer:CountDownTimer

    fun startTimer(timeSecond:Long){

        countDownTimer= object : CountDownTimer(timeSecond*1000+1000,1){
            override fun onTick(millisUntilFinished: Long) {
             //   binding.tvCount.text = (millisUntilFinished/1000).toString()
                liveDataBool.value=false
                liveData.value=(millisUntilFinished/1000).toString()

                //view.visibility=View.GONE
            }

            override fun onFinish() {
                liveData.value="0"

                liveDataBool.value=true    //Toast.makeText(getApplication(),"Finish",Toast.LENGTH_LONG).show()
//vibro(getApplication())
               // view.visibility=View.VISIBLE

            }

        }.start()


    }
fun sbrosTimer(){
    countDownTimer.cancel()
    liveData.value = "0"
}
}