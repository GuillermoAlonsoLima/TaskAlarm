package com.example.taskalarm

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask


class MainActivity : AppCompatActivity() {

    private val alarmDAO = AlarmDAO(this)

    companion object{
        var alarmes = ArrayList<Alarm>()
        var binding: ActivityMainBinding? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        alarmes.add(Alarm("teste",null,null,null,null, "19:45",null,null,this))
//        alarmes.add(Alarm("teste2",null,null,null,null, "10:00",null,null,this))
//        alarmes.add(Alarm("teste3","dsfdsf",true, arrayListOf("domingo","terca","quarta","quinta","sabado"),"11/07/2020", "9:15","bvff",
//            arrayListOf("teste1","teste2","teste3"),this))

        alarmes = alarmDAO.selecionarTudo()
        for(alarme in alarmes){
            println("ID:"+alarme.id)
        }

        binding!!.tarefasRvMain.layoutManager = LinearLayoutManager(this)

        binding!!.tarefasRvMain.adapter = AlarmAdapter(alarmes,this)

        Timer().schedule(timerTask {
            showAlarm(alarmes[0])
        }, 5000)
//        val intent = Intent(this, AlarmActivity::class.java).apply {
//            putExtra("data",data)
//            putExtra("hora",alarmes[2].data)
//            putExtra("titulo",alarmes[2].titulo)
//            putExtra("descricao",alarmes[2].descricao)
//            putExtra("tarefas",alarmes[2].tarefas)
//        }
//        this.startActivity(intent)
    }

    fun showAdicionar(view: View){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    fun showAlarm(alarm: Alarm){

//        val mp: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.alarm)
//        mp.setOnPreparedListener {
//            mp.start()
//        }

        val intent = Intent(this, AlarmActivity::class.java).apply {
            putExtra("data",alarm.data)
            putExtra("hora",alarm.hora)
            putExtra("titulo",alarm.titulo)
            putExtra("descricao",alarm.descricao)
            putExtra("tarefas",alarm.tarefas)
        }
        startActivity(intent)
    }

    override fun onStop() {

        super.onStop()
    }

}
