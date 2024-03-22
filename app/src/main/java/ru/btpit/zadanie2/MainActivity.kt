package ru.btpit.zadanie2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import org.jetbrains.annotations.Nullable
import ru.btpit.zadanie2.databinding.ActivityMainBinding

data class Post (
    val id:Long,
    val author: String,
    val content: String,
    val published: String,
    val isLiked: Boolean = false
)

class MainActivity : AppCompatActivity() {
    private var likesCount = 10
    private var isLiked = false
    private var shareCount = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            isLiked = false
                )
//        with(binding)
//        {
//            author.text = post.author
//            published.text = post.published
//            content.text= post.content
//            if(post.isLiked)
//            {
//                li
//            }
//        }

        val likeButton = findViewById<ImageButton>(R.id.imageButton)
        val shareButton = findViewById<ImageButton>(R.id.imageButton2)

        likeButton.setOnClickListener {
            if (isLiked) {
                likesCount--
                isLiked = false
                likeButton.setImageResource(R.mipmap.like) // Устанавливаем прозрачный цвет
            } else {
                likesCount++
                isLiked = true
                likeButton.setImageResource(R.mipmap.like2)
            }
            updateLikes()
        }
        shareButton.setOnClickListener {

            shareCount += 1


            updateShares()
        }


    }
    private fun updateLikes() {
        val likesTextView = findViewById<TextView>(R.id.textView)
        val formattedLikes = formatNumber(likesCount)
        likesTextView.text = formattedLikes
    }
    private fun formatNumber(number: Int): String {
        return when {
            number >= 1000000 -> {
                val value = number / 1000000
                val remainder = number % 1000000
                if (remainder > 0) {
                    if (remainder >= 100000) {
                        String.format("%.1f M", value + remainder / 1000000.0)
                    } else {
                        String.format("%d.%d M", value, remainder / 100000)
                    }
                } else {
                    "$value M"
                }
            }
            number in 1000..9999 -> {
                String.format("%.1fK", number / 1000.0)
            }
            number >= 10000 -> {
                String.format("%dK", number / 1000)
            }
            else -> number.toString()
        }
    }
    private fun updateShares() {
        val shareTextView = findViewById<TextView>(R.id.textView2)
        val formattedShare = formatNumber1(shareCount)
        shareTextView.text = formattedShare


    }
    private fun formatNumber1(number: Int): String {
        return when {
            number >= 1000000 -> {
                val value = number / 1000000
                val remainder = number % 1000000
                if (remainder > 0) {
                    if (remainder >= 100000) {
                        String.format("%.1f M", value + remainder / 1000000.0)
                    } else {
                        String.format("%d.%d M", value, remainder / 100000)
                    }
                } else {
                    "$value M"
                }
            }
            number in 1000..9999 -> {
                String.format("%.1fK", number / 1000.0)
            }
            number >= 10000 -> {
                String.format("%dK", number / 1000)
            }
            else -> number.toString()
        }
    }


}