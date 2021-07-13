package com.example.memessharemvp.presenter

import android.content.Context
import android.content.Intent
import com.example.memessharemvp.contract.MemeInterface.*
import com.example.memessharemvp.model.MainActivityModel

class MainActivityMemePresenter (_memeView: MemeView) : MemePresenter {
    private var memeView: MemeView = _memeView
    private var model: Model = MainActivityModel()

    private var currentImageUrl: String? = null

    override fun getMeme(context: Context) {
        memeView.onLoading()
        model.fetchMeme(
            context = context,
            onResponse = { url ->
                if (url != null){
                    currentImageUrl = url
                    memeView.updateView(url)
                } else{
                    memeView.onLoadingFailed()
                }
            }
        )
    }

    override fun shareMeme() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey, checkout this cool meme I got from Reddit $currentImageUrl")
        val chooser = Intent.createChooser(intent, "Share this meme using ... ")
        memeView.onStartActivity(chooser)
    }
}