package com.example.gmail

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Inbox"

        // Setup RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data
        val emails = listOf(
            Email(
                senderInitial = "E",
                sender = "Edurila.com",
                subject = "$19 Only (First 10 spots) - Bestselling...",
                preview = "Are you looking to Learn Web Design...",
                timestamp = "12:34 PM",
                isStarred = false,
                avatarColor = Color.parseColor("#4285F4")
            ),
            Email(
                senderInitial = "C",
                sender = "Chris Abad",
                subject = "Help make Campaign Monitor better",
                preview = "Let us know your thoughts! No Images...",
                timestamp = "11:22 AM",
                isStarred = false,
                avatarColor = Color.parseColor("#EA4335")
            ),
            Email(
                senderInitial = "T",
                sender = "Tuto.com",
                subject = "8h de formation gratuite et les nouvea...",
                preview = "Photoshop, SEO, Blender, CSS, WordPre...",
                timestamp = "11:04 AM",
                isStarred = false,
                avatarColor = Color.parseColor("#34A853")
            ),
            Email(
                senderInitial = "S",
                sender = "support",
                subject = "Société Ovh : suivi de vos services - hp...",
                preview = "SAS OVH - http://www.ovh.com 2 rue K...",
                timestamp = "10:26 AM",
                isStarred = false,
                avatarColor = Color.parseColor("#7A7A7A")
            ),
            Email(
                senderInitial = "M",
                sender = "Matt from Ionic",
                subject = "The New Ionic Creator Is Here!",
                preview = "Announcing the all-new Creator, build...",
                timestamp = "10:11 AM",
                isStarred = false,
                avatarColor = Color.parseColor("#FBBC05")
            )
        )

        // Set adapter
        val adapter = EmailAdapter(emails)
        recyclerView.adapter = adapter

        // Setup FloatingActionButton click
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Toast.makeText(this, "Compose new email", Toast.LENGTH_SHORT).show()
        }
    }
}