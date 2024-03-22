package ru.btpit.zadanie2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import ru.btpit.zadanie2.R
import ru.btpit.zadanie2.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.PostViewModel



class MainActivity : AppCompatActivity() {


    private var shareCount = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                val formattedLike = formatNumber(post.likecount)
                textView.text = formattedLike
                val formattedShare = formatNumber1(post.share)
                textView2.text = formattedShare


                like.setImageResource(
                    if (post.isLiked) R.mipmap.like2 else R.mipmap.like

                )



            }
        }
        binding.like.setOnClickListener {

            viewModel.like()


        }

        binding.share.setOnClickListener {


           viewModel.share()
        }


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