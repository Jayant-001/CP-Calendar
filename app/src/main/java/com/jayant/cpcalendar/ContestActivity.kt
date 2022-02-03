package com.jayant.cpcalendar

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import org.jsoup.Jsoup
import java.io.IOException

class ContestActivity : AppCompatActivity() {

    lateinit var loaderAnimation: LottieAnimationView
    lateinit var contestRecycler : RecyclerView
    lateinit var progressBar : ProgressBar
    lateinit var key : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)

        loaderAnimation = findViewById(R.id.loading_animation)
        contestRecycler = findViewById(R.id.contestRecycler)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility  = View.GONE
        contestRecycler.layoutManager = LinearLayoutManager(this)

        key = intent.getStringExtra("sitename").toString()
        Toast.makeText(this@ContestActivity, key, Toast.LENGTH_SHORT).show()

        FetchContestData().execute()
    }

    @SuppressLint("StaticFieldLeak")
    inner class FetchContestData : AsyncTask<Void, Void, Void>() {

        var contestList = ArrayList<ContestData>()
        override fun doInBackground(vararg params: Void?): Void? {

            try {

                var doc = Jsoup.connect("https://www.stopstalk.com/contests").get()

                var contest_list = doc.getElementsByTag("tbody")

                for (c in contest_list) {
                    var contestRow = c.getElementsByTag("tr")

                    for (signleContest in contestRow) {

                        var td2 = signleContest.getElementsByTag("td")

                        var siteName = td2[1].getElementsByAttribute("title").attr("title")
                        var contestName = signleContest.text()

                        if(contestName.length >= 20) {

                            when(key) {
                                "codeforces" -> {
                                    if(siteName == "CodeForces") {
                                        contestList.add(ContestData(contestName,siteName))
                                    }
                                }
                                "codechef" -> {
                                    if(siteName == "CodeChef") {
                                        contestList.add(ContestData(contestName, siteName))
                                    }
                                }
                                "hackerrank" -> {
                                    if(siteName == "HackerRank") {
                                        contestList.add(ContestData(contestName, siteName))
                                    }
                                }
                                "hackerearth" -> {
                                    if(siteName == "HackerEarth") {
                                        contestList.add(ContestData(contestName, siteName))
                                    }
                                }
                                "leetcode" -> {
                                    if(siteName == "LeetCode")
                                        contestList.add(ContestData(contestName, siteName))

                                }
                                "atcoder" -> {
                                    if(siteName == "AtCoder") {
                                        contestList.add(ContestData(contestName, siteName))
                                    }
                                }
                                else -> {
                                    contestList.add(ContestData(contestName, siteName))
                                }
                            }


//                            contestList.add(ContestData(contestName, siteName))
                        }

                    }

                }

            }
            catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)

            progressBar.visibility = View.GONE
            loaderAnimation.visibility = View.GONE

            val adapter = ContestAdapter(contestList, key)
            contestRecycler.adapter = adapter

        }
    }
}