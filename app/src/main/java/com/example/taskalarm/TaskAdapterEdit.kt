package com.example.taskalarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapterEdit(private val tasks: List<String>) :
    RecyclerView.Adapter<TaskAdapterEdit.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val taskCheckBox = itemView.findViewById<TextView>(R.id.taskCbTaskItem) as CheckBox
        val deletarButton = itemView.findViewById<TextView>(R.id.deletarBtnTaskItem) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val adapterView = inflater.inflate(R.layout.task_item, parent, false)
        return ViewHolder(adapterView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val task: String = tasks[position]
        viewHolder.taskCheckBox.text = task
        viewHolder.deletarButton.setOnClickListener{
            EditActivity.tarefas.removeAt(position)
            EditActivity.tasksRv!!.adapter = TaskAdapterEdit(tasks)
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}