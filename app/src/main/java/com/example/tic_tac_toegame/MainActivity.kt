package com.example.tic_tac_toegame

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    
    fun play(v: View){
        Toast.makeText(applicationContext, "OPENING", Toast.LENGTH_SHORT).show()
        intent = Intent(this,TTTgame::class.java)
        startActivity(intent)

    }
    fun exit(v: View){
        this@MainActivity.finish()
        exitProcess(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}