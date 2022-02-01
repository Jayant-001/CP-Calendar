package com.jayant.cpcalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
     lateinit var codeChefBtn : Button
    lateinit var codeForcesBtn : Button
    lateinit var hackerRankBtn : Button
    lateinit var hackerEarthBtn : Button
    lateinit var leetCodeBtn : Button
    lateinit var atcoderButton : Button
    lateinit var allContestBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        codeChefBtn = findViewById(R.id.codechef_btn)
        codeForcesBtn = findViewById(R.id.codeforces_btn)
        hackerRankBtn = findViewById<Button>(R.id.hackerrank_btn)
        hackerEarthBtn = findViewById<Button>(R.id.hackerearth_btn)
        leetCodeBtn = findViewById<Button>(R.id.leetcode_btn)
        atcoderButton = findViewById<Button>(R.id.atcoder_btn)
        allContestBtn = findViewById<Button>(R.id.all_contest_btn)

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