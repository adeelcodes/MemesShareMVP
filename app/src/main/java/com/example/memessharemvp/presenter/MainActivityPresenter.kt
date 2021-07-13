package com.example.memessharemvp.presenter

import com.example.memessharemvp.contract.ContractInterface.*
import com.example.memessharemvp.model.MainActivityModel

class MainActivityPresenter (_view: View) : Presenter {
    private var view: View = _view
    private var model: Model = MainActivityModel()

    init {
        view.initView()
    }

    override fun getMeme() {
        model.fetchMeme()
        view.updateView()
    }
}