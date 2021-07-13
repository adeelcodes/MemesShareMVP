package com.example.memessharemvp.contract

import android.content.Context
import android.content.Intent

interface MemeInterface {
    interface MemeView {
        fun updateView(url: String)
        fun onLoading()
        fun onLoadingFailed()
        fun onStartActivity(intent: Intent)
    }

    interface MemePresenter {
        fun getMeme(context: Context)
        fun shareMeme()
    }

    interface Model {
        fun fetchMeme(context: Context, onResponse: (String?) -> Unit)
    }
}