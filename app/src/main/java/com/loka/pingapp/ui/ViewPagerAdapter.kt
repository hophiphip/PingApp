package com.loka.pingapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.loka.pingapp.R
import com.loka.pingapp.models.ViewPagerItem

class ViewPagerAdapter(
    private var viewPagerItems: List<ViewPagerItem>,
    private var viewPager2: ViewPager2
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (viewPagerItems.size == position)
            LastViewPagerHolder.viewTypeId
        else
            ViewPagerHolder.viewTypeId
    }

    override fun getItemCount(): Int {
        // All items + additional last one
        return viewPagerItems.size + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            LastViewPagerHolder.viewTypeId -> return LastViewPagerHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_pager_last_item,
                    parent,
                    false
                )
            )

            else -> return ViewPagerHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_pager_item,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            LastViewPagerHolder.viewTypeId -> {
                (holder as LastViewPagerHolder).setItem()
            }

            ViewPagerHolder.viewTypeId -> {
                (holder as ViewPagerHolder).setItem()
            }
        }
    }
}