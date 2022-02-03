package com.jayant.cpcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
     lateinit var codeChefBtn : CardView
    lateinit var codeForcesBtn : CardView
    lateinit var hackerRankBtn : CardView
    lateinit var hackerEarthBtn : CardView
    lateinit var leetCodeBtn : CardView
    lateinit var atcoderButton : CardView
    lateinit var allContestBtn : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        codeChefBtn = findViewById(R.id.codechef_btn)
        codeForcesBtn = findViewById(R.id.codeforces_btn)
        hackerRankBtn = findViewById(R.id.hackerrank_btn)
        hackerEarthBtn = findViewById(R.id.hackerearth_btn)
        leetCodeBtn = findViewById(R.id.leetcode_btn)
        atcoderButton = findViewById(R.id.atcoder_btn)
        allContestBtn = findViewById(R.id.all_contest_btn)

        codeChefBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "codechef")
            startActivity(intent)
        }

        codeForcesBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "codeforces")
            startActivity(intent)
        }

        hackerRankBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "hackerrank")
            startActivity(intent)
        }

        hackerEarthBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "hackerearth")
            startActivity(intent)
        }

        leetCodeBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "leetcode")
            startActivity(intent)
        }

        atcoderButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "atcoder")
            startActivity(intent)
        }

        allContestBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, ContestActivity::class.java)
            intent.putExtra("sitename", "allcontest")
            startActivity(intent)
        }

    }
}