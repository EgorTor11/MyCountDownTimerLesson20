package com.example.mycountdowntimerlesson20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycountdowntimerlesson20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mViewModel:MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

binding.root.setOnClickListener{
    if (mViewModel.liveData.value=="0"){
        mViewModel.startTimer()
        mViewModel.liveData.observe(this, Observer {
            binding.tvCount.text=it
        })
    }
    }

    }



}