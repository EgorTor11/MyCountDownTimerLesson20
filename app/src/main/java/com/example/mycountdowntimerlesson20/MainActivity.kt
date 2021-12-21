package com.example.mycountdowntimerlesson20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycountdowntimerlesson20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val numberList = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " ")
    lateinit var mViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.tvCount.setOnClickListener {
            var str = "0"
            binding.editTextTextPersonName.text.toString().forEach {
                if (!numberList.contains(it.toString())) {
                    Toast.makeText(this, "укажите целое число секунд", Toast.LENGTH_LONG).show()
                } else {
                    str = binding.editTextTextPersonName.text.toString().trim()
                }
            }

            if (mViewModel.liveData.value == null || mViewModel.liveData.value == "0") {
                 mViewModel.startTimer(str.toLong())//
                mViewModel.liveData.observe(this, Observer {
                    binding.tvCount.text = it
                })
            } else {
                mViewModel.countDownTimer.cancel()
                mViewModel.liveData.value = "0"
                Toast.makeText(getApplication(), "Таймер сброшен", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onStart() {
        super.onStart()

        mViewModel.liveData.observe(
            this,
            Observer { binding.tvCount.text = mViewModel.liveData.value })
    }
}

