package com.example.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytodolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
        Variable that content the activity_main.xml with MainActivity class.
        With the help of this variable we no longer need to use findViewById method. We can use
        binding.{view_id} instead.
     */
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the activity_main.xml and attach it to binding variable
        binding = ActivityMainBinding.inflate(layoutInflater)
        // set the contents on the screen with the binding variable
        setContentView(binding.root)
    }
}