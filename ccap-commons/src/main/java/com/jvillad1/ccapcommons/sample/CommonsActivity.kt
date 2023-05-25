package com.jvillad1.ccapcommons.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jvillad1.ccap.databinding.ActivityCommonsBinding

class CommonsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCommonsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}