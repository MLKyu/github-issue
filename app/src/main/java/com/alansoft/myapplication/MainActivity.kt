package com.alansoft.myapplication

import android.os.Bundle
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
            .replace(R.id.container, ListFragment.newInstance(userName, repository))
            .commitNow()
    }

    override fun onResume() {
        super.onResume()
        handleDeepLink()
    }

    private fun handleDeepLink() {
        if(intent == null) return

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val userName = it.getString(DeepLinkActivity.GITHUB_USER_NAME, "")
            val repository = it.getString(DeepLinkActivity.REPOSITORY_NAME, "")

            supportFragmentManager.beginTransaction().add(R.id.container, ListFragment.newInstance(userName, repository)).commit()
        }
    }

}
