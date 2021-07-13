package com.example.memessharemvp.model

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.memessharemvp.contract.ContractInterface.*

class MainActivityModel: AppCompatActivity(), Model {

    private var currentImageUrl : String? = null

    override fun fetchMeme() {
        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                currentImageUrl = response.getString("url")
            },
            { error ->
                println("Some error occurred ")
            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun sendMemeToPresenter() = currentImageUrl

}