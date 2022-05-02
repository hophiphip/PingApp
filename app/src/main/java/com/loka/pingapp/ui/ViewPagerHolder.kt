package com.loka.pingapp.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.loka.pingapp.R

/**
 * Default item in ViewPager.
 */
class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var cardView: MaterialCardView = itemView.findViewById(R.id.view_pager_item)
    private var cardTextView: TextView = itemView.findViewById(R.id.view_pager_item_text)

    fun setItem() {
        cardTextView.text = "Some card"
    }

    companion object {
        const val viewTypeId = 0
    }
}