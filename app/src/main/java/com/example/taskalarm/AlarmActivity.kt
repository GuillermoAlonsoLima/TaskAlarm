package com.example.taskalarm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskalarm.databinding.AlarmBinding

class AlarmActivity: AppCompatActivity() {

    var binding: AlarmBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm)

        binding = DataBindingUtil.setContentView(this, R.layout.alarm)

        if(intent.getStringExtra("data") != null){
            binding!!.horaTxtAlarm.text = intent.getStringExtra("data")+" "+intent.getStringExtra("hora")
        }else{
            binding!!.horaTxtAlarm.text = intent.getStringExtra("hora")
        }
        binding!!.tituloTxtAlarm.text = intent.getStringExtra("titulo")
        if(intent.getStringExtra("descricao") != null){
            binding!!.descricaoTxtAlarm.text = intent.getStringExtra("descricao")
        }else{
            binding!!.descricaoTxtAlarm.text = ""
        }
        binding!!.fecharAlarmeBtnAlarm.setOnClickListener{
            fechar()
        }

        if(intent.getStringArrayListExtra("tarefas") != null){
            binding!!.listaTarefasRvAlarm.layoutManager = LinearLayoutManager(this)
            binding!!.listaTarefasRvAlarm.adapter = TaskAdapterAlarm(intent.getStringArrayListExtra("tarefas"))
        }

    }

    fun fechar(){
        finish()
    }

}