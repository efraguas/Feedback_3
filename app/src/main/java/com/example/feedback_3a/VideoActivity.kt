package com.example.feedback_3a

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.example.feedback_3a.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var videoView: VideoView
        binding.reproductor.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.prueba))
        binding.reproductor.setMediaController(MediaController(this))
        binding.reproductor.requestFocus()
        binding.reproductor.start()

    }
}