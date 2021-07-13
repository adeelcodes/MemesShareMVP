package com.example.memessharemvp.contract

interface ContractInterface {
    interface View {
        fun initView()
        fun updateView()
    }

    interface Presenter {
        fun getMeme()
    }

    interface Model {
        fun fetchMeme()
        fun sendMemeToPresenter(): String?
    }
}