package com.example.jetpack2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskalarm.Alarm
import com.example.taskalarm.R
import java.text.SimpleDateFormat


class AlarmAdapter (private val alarms: List<Alarm>) : RecyclerView.Adapter<AlarmAdapter.ViewHolder>()
{
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val horaTextView = itemView.findViewById<TextView>(R.id.horaTxtItem)
        val tituloTextView = itemView.findViewById<TextView>(R.id.tituloTxtItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val adapterView = inflater.inflate(R.layout.alarm_item, parent, false)
        return ViewHolder(adapterView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val alarm: Alarm = alarms.get(position)
        viewHolder.horaTextView.text = alarm.hora
        viewHolder.tituloTextView.text = alarm.titulo
//        viewHolder.itemView.setOnClickListener({
//            MainActivity.showEditAlarm(alarm)
//        })
    }

    override fun getItemCount(): Int {
        return alarms.size
    }
}
