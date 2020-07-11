package com.example.taskalarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    companion object{
        val alarmes = ArrayList<Alarm>()
        var binding: ActivityMainBinding? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        alarmes.add(Alarm("teste",null,null,null,null, "11:30",null,null))
        alarmes.add(Alarm("teste2",null,null,null,null, "10:00",null,null))
        alarmes.add(Alarm("teste3","dsfdsf",true, arrayListOf("Domingo","Terca","Quarta","Quinta","Sabado"),"11/07/2020", "9:15","bvff",null))

        binding!!.tarefasRvMain.layoutManager = LinearLayoutManager(this)

        binding!!.tarefasRvMain.adapter = AlarmAdapter(alarmes,this)

        Timer().schedule(timerTask {
            showAlarme(alarmes[2])
        }, 5000)

    }

    fun showAdicionar(view: View){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    fun showAlarme(alarm: Alarm){

        val intent = Intent(this, AlarmActivity::class.java).apply {
            putExtra("data",alarm.data)
            putExtra("hora",alarm.hora)
            putExtra("titulo",alarm.titulo)
            putExtra("descricao",alarm.descricao)
        }
        startActivity(intent)
    }
}
