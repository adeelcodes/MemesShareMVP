package com.example.memessharemvp.model

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.memessharemvp.contract.MemeInterface.Model

class MainActivityModel: Model {

    private val url = "https://meme-api.herokuapp.com/gimme"
    private var currentImageUrl : String? = null

    override fun fetchMeme(
        context: Context,
        onResponse: (String?) -> Unit
    ) {
        //TODO: Move this out
        val queue = Volley.newRequestQueue(context)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                currentImageUrl = response.getString("url")
                onResponse(currentImageUrl)
            },
            { error ->
                Log.d("MainActivityModel", error.message.toString())
            }
        )
        queue.add(jsonObjectRequest)
        //MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    //override fun sendMemeToPresenter() = currentImageUrl

}