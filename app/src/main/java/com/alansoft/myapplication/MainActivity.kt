package com.alansoft.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alansoft.myapplication.deeplink.DeepLinkActivity
import com.alansoft.myapplication.ui.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment.newInstance())
            .commitNow()
    }

    override fun onResume() {
        super.onResume()
        handleDeepLink()
    }

    private fun handleDeepLink() {
        if(intent == null) return

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            Log.d("lmk","MainActivity GITHUB_USER_NAME :" + bundle.getString(DeepLinkActivity.GITHUB_USER_NAME));
            Log.d("lmk","MainActivity REPOSITORY_NAME :" + bundle.getString(DeepLinkActivity.REPOSITORY_NAME));
        }
    }

}
