package com.loka.pingapp.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.loka.pingapp.R

/**
 * Last item in ViewPager.
 */
class LastViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var cardView: MaterialCardView = itemView.findViewById(R.id.view_pager_last_item)
    private var cardTextView: TextView = itemView.findViewById(R.id.view_pager_last_item_text)

    fun setItem() {
        cardTextView.text = "Add item"
    }

    companion object {
        const val viewTypeId = 1
    }
}