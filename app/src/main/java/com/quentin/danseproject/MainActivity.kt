package com.quentin.danseproject

import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var mybutton : Button
    private lateinit var mywebView: WebView
    private lateinit var myeditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mybutton = findViewById(R.id.mybutton)
        mywebView = findViewById(R.id.mywebView)
        myeditText = findViewById(R.id.myedittext)

        mywebView.webViewClient = WebViewClient()

        mywebView.settings.javaScriptEnabled = true

        mywebView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                handler.proceed()
            }
        }

        mywebView.loadUrl("https://avatar-eemi.distribute.app/")

        mybutton.setOnClickListener {
            val id = myeditText.text.toString()
            mywebView.loadUrl("https://avatar-eemi.distribute.app/avatar/animate/${id}")
        }

    }
}