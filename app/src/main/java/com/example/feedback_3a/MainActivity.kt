package com.example.feedback_3a

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.feedback_3a.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaRecord: MediaRecorder

    //        Environment.getExternalStorageDirectory().path

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root )
        mediaRecord = MediaRecorder()
        val archivo = File("/sdcard/Download","nuevagrabacion.mp3")

        mediaRecord.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecord.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mediaRecord.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        mediaRecord.setOutputFile(archivo)


        //boton de iniciar la grabacion
        binding.grabar.setOnClickListener {
            mediaRecord.prepare()
            mediaRecord.start()
            Snackbar.make(binding.root,"Iniciando grabacion",Snackbar.LENGTH_SHORT).show()
        }

        //boton detencion
        binding.stop.setOnClickListener {
            mediaRecord.stop()
            mediaRecord.release()
            Snackbar.make(binding.root,"Grabacion detenida",Snackbar.LENGTH_SHORT).show()
        }

        binding.video.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }


    }


}