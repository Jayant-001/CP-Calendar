package com.jayant.cpcalendar

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AboutmeActivity : AppCompatActivity() {

    lateinit var linkedUrl : LinearLayout
    lateinit var contactNumber : LinearLayout
    lateinit var githubLL : LinearLayout
    lateinit var emailLL : LinearLayout
    lateinit var kietEmailLL : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutme)

        linkedUrl = findViewById(R.id.linked_ll)
        contactNumber = findViewById(R.id.contact_ll)
        githubLL = findViewById(R.id.github_ll)
        emailLL = findViewById(R.id.email_ll)
        kietEmailLL = findViewById(R.id.kiet_email_ll)

        contactNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:07081263001")
            startActivity(intent)
        }

        linkedUrl.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jayant-cse/"))
            startActivity(browserIntent)
        }

        githubLL.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Jayant-001"))
            startActivity(browserIntent)
        }

        emailLL.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:jayantgupta730@gmail.com"))
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
//            emailIntent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(emailIntent, "Chooser app to send email"))
        }

        kietEmailLL.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(label.toString(), "jayant.2024cse1207@kiet.edu")
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Email copied to your clipboard", Toast.LENGTH_SHORT).show()
//            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("jayant.2024cse1207@kiet.edu"))
//            startActivity(Intent.createChooser(emailIntent, "Chooser Title"))
        }

    }
}