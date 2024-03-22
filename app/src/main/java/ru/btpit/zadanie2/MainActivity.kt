package ru.btpit.zadanie2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import org.jetbrains.annotations.Nullable

class MainActivity : AppCompatActivity() {
    private var likesCount = 10
    private var isLiked = false
    private var shareCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val likeButton = findViewById<ImageButton>(R.id.imageButton)
        val shareButton = findViewById<ImageButton>(R.id.imageButton2)
        val likesTextView = findViewById<TextView>(R.id.textView)
        val shareTextView = findViewById<TextView>(R.id.textView2)
        likeButton.setOnClickListener {
            if (isLiked) {
                likesCount--
                isLiked = false
                likeButton.isPressed = false
            } else {
                likesCount++
                isLiked = true
                likeButton.isPressed = true
            }
            updateLikes()
        }
        shareButton.setOnClickListener {
            if (shareCount < 999) {
                shareCount += 10
            } else {
                shareCount = 10
            }
            updateShares()
        }


    }
    private fun updateLikes() {
        val likesTextView = findViewById<TextView>(R.id.textView)
        if (likesCount >= 1000) {
            likesTextView.text = "${likesCount / 1000}K"
        } else {
            likesTextView.text = likesCount.toString()
        }
    }
    private fun updateShares() {
        val shareTextView = findViewById<TextView>(R.id.textView2)
        if (shareCount >= 1000) {
            shareTextView.text = "${shareCount / 1000}K"
        } else {
            shareTextView.text = shareCount.toString()
        }
    }


}