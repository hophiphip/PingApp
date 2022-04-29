package com.loka.pingapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.loka.pingapp.utils.Ip
import com.loka.pingapp.utils.Network

class MainActivity : AppCompatActivity() {
    private lateinit var networkRequest: NetworkRequest
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    private fun connectivityManager() = this@MainActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkRequest = Network.request()
        networkCallback = Network.callback(this@MainActivity)

        setTextContents()
        connectivityManager().registerNetworkCallback(networkRequest, networkCallback)
    }

    private fun setTextContents() {
        val mainTextView: TextView = findViewById(R.id.main_text_view_id)
        mainTextView.text = Ip.address()
    }
}