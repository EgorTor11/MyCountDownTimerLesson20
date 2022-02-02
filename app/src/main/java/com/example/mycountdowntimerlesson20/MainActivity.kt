package com.example.mycountdowntimerlesson20


import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycountdowntimerlesson20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.liveDataBool.value = false
        mViewModel.liveDataBoolToastVibroSbros.value = false
        mViewModel.liveDataBoolToastUCCHS.value = false
        mViewModel.liveData.observe(
            this,
            Observer { binding.tvStartDownTimer.text = mViewModel.liveData.value })

        mViewModel.liveDataBool.observe(
            this,
            Observer {
                if (it == true) {
                    Toast.makeText(this, "Finish", Toast.LENGTH_LONG).show()
                    vibro(this)
                    binding.imageView.visibility = View.VISIBLE
                } else {
                    binding.imageView.visibility = View.GONE
                }
            })

        mViewModel.liveDataBoolToastVibroSbros.observe(this, {
            if (it == true) {
                Toast.makeText(this, "Таймер сброшен", Toast.LENGTH_LONG).show()
                vibro(this)
            }
        })
        mViewModel.liveDataBoolToastUCCHS.observe(this, {
            if (it == true) {
                Toast.makeText(this, "укажите целое число секунд", Toast.LENGTH_LONG).show()
            }
        })

        binding.tvStartDownTimer.setOnClickListener {
            mViewModel.onStartTimerClick(binding.editTextTextPersonName.text.toString())
        }

    }


}

