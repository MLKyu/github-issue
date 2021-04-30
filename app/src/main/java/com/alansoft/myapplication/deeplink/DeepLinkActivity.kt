package com.alansoft.myapplication.deeplink

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class DeepLinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val bundle = Bundle()
        if (Intent.ACTION_VIEW == intent.action) {
            val uri: Uri? = intent.data
            if (uri != null) {
                val scheme = uri.scheme
                val host = uri.host
                val path = uri.path

                Log.d("lmk","scheme :" + scheme);
                Log.d("lmk","host :" + host);
                Log.d("lmk","path :" + path);
            }
        }
    }
}