package com.jayant.cpcalendar

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var codeChefBtn : CardView
    lateinit var codeForcesBtn : CardView
    lateinit var hackerRankBtn : CardView
    lateinit var hackerEarthBtn : CardView
    lateinit var leetCodeBtn : CardView
    lateinit var atcoderButton : CardView
    lateinit var allContestBtn : CardView
    lateinit var contactBtn : CardView

    lateinit var quoteText : TextView

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
        contactBtn = findViewById(R.id.contact_btn)

        quoteText = findViewById(R.id.quote_text)

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

        contactBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutmeActivity::class.java))
        }

        if(ConnectionManager().checkConnectivity(this)) {
            Toast.makeText(this, "Welcome to CP Calendar", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Internet not found", Toast.LENGTH_SHORT).show()

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Error")
            dialog.setMessage("Check your internet connection")
            dialog.setCancelable(false)
            dialog.setPositiveButton("CONNECT") { text, listener ->
                // do any thing
                val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
//                intent.setClassName("com.android.phone", "com.android.phone.NetworkSetting")
                startActivity(intent)
                finish()
            }
            dialog.setNegativeButton("EXIT") {text, listener ->
                // so someting
                finish()
            }
            dialog.create()
            dialog.show()
        }

        loadQuote()
    }

    private fun loadQuote() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://zenquotes.io/api/random"

        val jsonRequest = JsonArrayRequest(
            Request.Method.GET, url, null, { response ->
                val jsonObject = response.getJSONObject(0)
                val text = jsonObject.getString("q")
                quoteText.text = text
                Log.d("debug", text)
            },
            {
                error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
//                quoteText.text = "Happy Coding"
                Log.d("debug", error.toString())
            })

        queue.add(jsonRequest)
    }
}