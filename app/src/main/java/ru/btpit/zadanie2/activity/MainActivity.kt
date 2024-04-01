package ru.btpit.zadanie2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import ru.btpit.zadanie2.R
import ru.btpit.zadanie2.databinding.ActivityMainBinding
import ru.btpit.zadanie2.databinding.ActivityPostsBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.PostViewModel



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: PostViewModel by viewModels()
        val adapter = Posts({
            viewModel.like(it.id)
        }, {
            viewModel.share(it.id)
        })

        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }


        // Обработчик нажатия на кнопку share


//        val adapterr = posts {
//            viewModel.share(it.id)
//        }
//        binding.list.adapter = adapterr
//        viewModel.data.observe(this) { posts ->
//            adapter.submitList(posts)
//        }

//        val viewModel: PostViewModel by viewModels()
//        viewModel.data.observe(this) { post ->
//            post.map {post ->
//                binding.container.removeAllViews()
//                ActivityMainBinding.inflate(layoutInflater, binding., true).apply{
//                    author.text = post.author
//                    published.text = post.published
//                    content.text = post.content
//                    val formattedLike = formatNumber(post.likecount)
//                    textView.text = formattedLike
//                    val formattedShare = formatNumber1(post.share)
//                    textView2.text = formattedShare
//
//
//                    like.setImageResource(
//                        if (post.isLiked) R.mipmap.like2 else R.mipmap.like
//
//                    )
//                    like.setOnClickListener {
//
//                        viewModel.like(post.id)
//
//
//                    }
//                    share.setOnClickListener {
//
//
//                        viewModel.share(post.id)
//                    }
//                }.root
//
//            }
//        }


    }
}



