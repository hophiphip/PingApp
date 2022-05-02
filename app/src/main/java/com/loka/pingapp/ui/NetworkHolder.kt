package com.loka.pingapp.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.loka.pingapp.R
import com.loka.pingapp.models.Network

/**
 * Default item in ViewPager.
 */
class NetworkHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var networkHolderView: MaterialCardView = itemView.findViewById(R.id.network_item)
    private var networkNameTextView: TextView = itemView.findViewById(R.id.network_name)
    private var networkGatewayAddressTextView: TextView = itemView.findViewById(R.id.network_gateway_address)
    private var networkClientAddressTextView: TextView = itemView.findViewById(R.id.network_client_address)

    fun setItem(position: Int, network: Network) {
        networkNameTextView.text = network.name
        networkGatewayAddressTextView.text = network.gatewayAddress
        networkClientAddressTextView.text = network.clientAddress
    }

    companion object {
        const val viewTypeId = 0
    }
}