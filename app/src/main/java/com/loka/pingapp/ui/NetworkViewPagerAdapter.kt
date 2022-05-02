package com.loka.pingapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.loka.pingapp.R
import com.loka.pingapp.models.Network

class NetworkViewPagerAdapter(
    private var networks: List<Network>,
    private var viewPager2: ViewPager2
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (networks.size == position)
            AddNewNetworkHolder.viewTypeId
        else
            NetworkHolder.viewTypeId
    }

    override fun getItemCount(): Int {
        return networks.size + 1 // All items + additional last one
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            AddNewNetworkHolder.viewTypeId -> return AddNewNetworkHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_pager_add_network_item_item,
                    parent,
                    false
                )
            )

            else -> return NetworkHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_pager_network_item,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            AddNewNetworkHolder.viewTypeId -> {
                (holder as AddNewNetworkHolder).setItem()
            }

            NetworkHolder.viewTypeId -> {
                (holder as NetworkHolder).setItem(position, networks[position])
            }
        }
    }
}