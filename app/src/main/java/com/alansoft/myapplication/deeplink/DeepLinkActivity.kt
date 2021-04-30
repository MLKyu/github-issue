package com.alansoft.myapplication.deeplink

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

class DeepLinkActivity : Activity() {

    companion object {
        const val GITHUB_USER_NAME = "GITHUB_USER_NAME"
        const val REPOSITORY_NAME = "REPOSITORY_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Intent.ACTION_VIEW == intent.action) {
            val uri: Uri? = intent.data
            var githubUserName : String? = null
            var repositoryName : String? = null

            if (uri != null) {
                githubUserName = uri.host
                try {
                    repositoryName = uri.path?.let {
                        it.split("/")[1]
                    }.toString()
                } catch (e : Exception) {
                    //error
                } finally {
                    if(! githubUserName.isNullOrBlank() && ! repositoryName.isNullOrBlank()) {
                        val bundle = Bundle()
                        val intent: Intent? = packageManager.getLaunchIntentForPackage(packageName)
                        bundle.putString("GITHUB_USER_NAME", githubUserName)
                        bundle.putString("REPOSITORY_NAME", repositoryName)
                        intent?.putExtras(bundle)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

}