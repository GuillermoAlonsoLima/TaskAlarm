package com.example.jetpack2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskalarm.Alarm
import com.example.taskalarm.EditActivity
import com.example.taskalarm.R


class AlarmAdapter (private val alarms: List<Alarm>, val context: Context) : RecyclerView.Adapter<AlarmAdapter.ViewHolder>()
{
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val horaTextView: TextView = itemView.findViewById<TextView>(R.id.horaTxtItem)
        val tituloTextView:TextView = itemView.findViewById<TextView>(R.id.tituloTxtItem)
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
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, EditActivity::class.java).apply {
                putExtra("id",alarm.id)
                putExtra("titulo", alarm.titulo)
                putExtra("descricao", alarm.descricao)
                putExtra("silencio", alarm.silencio)
                putExtra("dias", alarm.dias)
                putExtra("data", alarm.data)
                putExtra("hora", alarm.hora)
                putExtra("endereco", alarm.endereco)
                putExtra("tarefas", alarm.tarefas)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return alarms.size
    }
}
