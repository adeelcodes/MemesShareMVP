package com.example.memessharemvp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.memessharemvp.R
import com.example.memessharemvp.contract.MemeInterface.MemePresenter
import com.example.memessharemvp.contract.MemeInterface.MemeView
import com.example.memessharemvp.presenter.MainActivityMemePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), MemeView  {

    private lateinit var memePresenter: MemePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        memePresenter = MainActivityMemePresenter(this)
        memePresenter.getMeme(this)

        nextButton.setOnClickListener {
            memePresenter.getMeme(this)
        }

        shareButton.setOnClickListener {
            memePresenter.shareMeme()
        }
    }

    override fun updateView(url: String) {
        progressBar.visibility = View.GONE
        Glide.with(this).load(url).into(memeImageView)
    }

    override fun onLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onLoadingFailed() {
        progressBar.visibility = View.GONE
        Toast.makeText(this, "warh gaye", Toast.LENGTH_SHORT).show()
    }

    override fun onStartActivity(intent: Intent) {
        startActivity(intent)
    }

}