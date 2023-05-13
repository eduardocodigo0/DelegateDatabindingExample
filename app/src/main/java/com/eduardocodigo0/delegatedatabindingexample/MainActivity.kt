package com.eduardocodigo0.delegatedatabindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eduardocodigo0.delegatedatabindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    DataBindingUser<ActivityMainBinding> by DataBindingUserImpl(ActivityMainBinding::inflate) {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inflateViewBinding(layoutInflater, this)

        getBind().btnname = "Click me"
        getBind().myButton.setOnClickListener {
            ++counter
            getBind().btnname = "Clicked $counter times"
        }
        setContentView(getBind().root)
    }
}