package com.loka.pingapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.loka.pingapp.ui.ViewPagerAdapter
import com.loka.pingapp.models.ViewPagerItem
import com.loka.pingapp.utils.Network
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private val TAG = this::class.java.name

    private lateinit var viewPager2: ViewPager2
    private lateinit var itemTextView: TextView

    private lateinit var networkRequest: NetworkRequest
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    private fun connectivityManager() = this@MainActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.main_view_pager)
        itemTextView = findViewById(R.id.main_current_pager_item)

        networkRequest = Network.request()
        networkCallback = Network.callback(this@MainActivity)

        initNetworkCallbacks()
        initViewPager()
    }

    private fun initNetworkCallbacks() {
        connectivityManager().registerNetworkCallback(networkRequest, networkCallback)
    }

    private fun initViewPager() {
        val viewPagerItems: List<ViewPagerItem> = arrayListOf(
            ViewPagerItem(R.drawable.muir_beach),
            ViewPagerItem(R.drawable.rainbow_falls),
            ViewPagerItem(R.drawable.rockaway_beach),
            ViewPagerItem(R.drawable.sf_coast),
            ViewPagerItem(R.drawable.shipwreck_1),
            ViewPagerItem(R.drawable.shipwreck_2)
        )

        viewPager2.adapter = ViewPagerAdapter(viewPagerItems, viewPager2)
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f

        })

        viewPager2.setPageTransformer(compositePageTransformer)

        viewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

                Log.i(TAG, "Current page $position")
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                Log.i(TAG,"Selected page $position")
                itemTextView.text = "Selected page ${position + 1}"
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }
}