package com.example.mvvmdemo

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.sql.DriverManager.println
import java.util.*

class KotlinActivity : AppCompatActivity() {
    private lateinit var et: EditText
    private lateinit var tv: TextView
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv_name)
        et = findViewById(R.id.et_name)
        tv.setText("", TextView.BufferType.NORMAL)
        tv.setOnClickListener { var isClick: Boolean = true }
        et.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }
        })
        user = User()


//        Handler().postDelayed(Runnable { },1000)
//   var viewmodel:MyViewModel =   ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MyViewModel::class.java)

    }

    fun test1(age: Int): String {
        user?.name = "";
        var name = user?.name
        var list: ArrayList<String> = ArrayList()

        return ""
    }

}