package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_5

import android.content.Context
import android.net.wifi.ScanResult
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R

class RecyclerAdapter(var context: Context, var wifiList: List<ScanResult>): RecyclerView.Adapter<RecyclerAdapter.ListHolder>() {

    inner class ListHolder(view: View): RecyclerView.ViewHolder(view) {
        val wifiName: TextView = view.findViewById(R.id.wifi_name_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.wifi_item, parent, false)
        return ListHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.wifiName.text = wifiList[position].SSID
    }

    override fun getItemCount(): Int {
        return wifiList.size
    }
}