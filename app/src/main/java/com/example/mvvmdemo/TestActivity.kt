package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmdemo.TestViewModel
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmdemo.R
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory

class TestActivity : AppCompatActivity() {
    private var viewModel: TestViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, NewInstanceFactory()).get(TestViewModel::class.java)

        viewModel!!.let {
            it.time.observe(this, { user -> })
            it.time.observe(this, { user -> println("onChanged1" + user.name) })}
//        viewModel!!.time.observe(this, { user -> })
//        viewModel!!.time.observe(this, { user -> println("onChanged1" + user.name) })

        with(viewModel!!){
           print("$time")
        }
    }
}