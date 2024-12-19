package com.example.cargame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), GameTask {
    lateinit var rootLayout: LinearLayout
    lateinit var startBtn : Button
    lateinit var GameView: GameView
    lateinit var score : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        GameView = GameView(this, this)

        startBtn.setOnClickListener{
            GameView.setBackgroundResource(R.drawable.img_2)
            rootLayout.addView(GameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE
        }
    }

    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(GameView)
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE

    }
}