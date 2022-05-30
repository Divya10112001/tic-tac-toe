package com.example.tic_tac_toegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class TTTgame : AppCompatActivity() {
    var active = true
    /*
    0=o
    1=X
    w= current winning position
     */
     var player =1
    var count=0
    var game = intArrayOf(2,2,2,2,2,2,2,2,2)
    var winpos = arrayOf(intArrayOf(0,1,2), intArrayOf(3,4,5),intArrayOf(6,7,8),intArrayOf(0,3,6),intArrayOf(1,4,7),
        intArrayOf(2,5,8),intArrayOf(0,4,8),intArrayOf(2,4,6))
    fun reset(v: View){

        player = 1
        active = true
        count = 0
        for (i in game.indices)
            game[i] = 2

        findViewById<ImageView>(R.id.imageView1).setImageResource(0)
        findViewById<ImageView>(R.id.imageView2).setImageResource(0)
        findViewById<ImageView>(R.id.imageView3).setImageResource(0)
        findViewById<ImageView>(R.id.imageView4).setImageResource(0)
        findViewById<ImageView>(R.id.imageView5).setImageResource(0)
        findViewById<ImageView>(R.id.imageView6).setImageResource(0)
        findViewById<ImageView>(R.id.imageView7).setImageResource(0)
        findViewById<ImageView>(R.id.imageView8).setImageResource(0)
        findViewById<ImageView>(R.id.imageView9).setImageResource(0)
        val t = findViewById<TextView>(R.id.status)
        t.text="O's Turn to Play"
    }

    fun tap(v:View) {
        val image = v as ImageView
        val txt = findViewById<TextView>(R.id.status)
        val tapimage = image.tag.toString().toInt()

        if(game[tapimage]==2) {
            count++

            if (player == 1) {
                image.setImageResource(R.drawable.o)
                player = 0
                //count++
                game[tapimage] = 1
                txt.text="X's Turn to play"
            } else {
                image.setImageResource(R.drawable.x)
                player = 1
                //count++
                game[tapimage] = 0
                txt.text="O's Turn to play"
            }
            image.translationY = -1000f
            image.animate().translationYBy(1000f).rotation(1800f).duration = 1000
            for (w in winpos) {
                if (game[w[0]] == game[w[1]] && game[w[1]] == game[w[2]] && game[w[0]] != 2) {

                    if (game[w[0]] == 0) {
                        txt.text = "X has won . Click to RESTART"

                    } else if (game[w[0]] == 1) {
                        txt.text = "O has won Click to RESTART"

                    }
                }
                if(count==9 )
                    {
                       txt.text="DRAW MATCH Click to RESTART"


                    }


            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tttgame)
    }
}