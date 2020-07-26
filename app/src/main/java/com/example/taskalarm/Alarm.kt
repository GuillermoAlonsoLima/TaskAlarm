package com.example.taskalarm

import android.content.Context
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timerTask


class Alarm(
    id:Long,
    titulo: String,
    descricao: String?,
    silencio: Boolean?,
    dias: ArrayList<String>?,
    data: String?,
    hora: String,
    endereco: String?,
    tarefas: ArrayList<String>?,
    context: Context?
) {
    var id = id
    var titulo = titulo
    var descricao = descricao
    var silencio = silencio
    var dias = dias
    var data = data
    var hora = hora
    var endereco = endereco
    var tarefas = tarefas
    val timer: Timer = Timer()

    init {
        if(!dias.isNullOrEmpty()){
            if(isCurrentDayInArray() && getDelay()>0) {
               //setTimer(context)
            }
        }else{
            //setTimer(context)
        }

    }

    private fun setTimer(context:Context){
        val teste = tarefas
        timer.schedule(timerTask {
            val intent = Intent(context, AlarmActivity::class.java).apply {
                putExtra("data",data)
                putExtra("hora",hora)
                putExtra("titulo",titulo)
                putExtra("descricao",descricao)
                putExtra("tarefas",tarefas)
            }
            context.startActivity(intent)
        }, getDelay())
    }

    private fun isCurrentDayInArray():Boolean{
        val sdf = SimpleDateFormat("EEEE")
        val d = Date()
        var dayOfTheWeek = sdf.format(d)
        if(!dias.isNullOrEmpty()){
            for(dia in dias!!){
                if(dia == dayOfTheWeek){
                    return true
                }
            }
        }
        return false
    }

    private fun getDelay():Long{
        var format: SimpleDateFormat?
        var horaFormatted: Date?
        if(data == null){
            format = SimpleDateFormat("dd/MM/yyyy")
            val currentDate = format.format(Date())
            format = SimpleDateFormat("dd/MM/yyyy HH:mm")
            horaFormatted = format.parse("$currentDate $hora")
        }else{
            format = SimpleDateFormat("dd/MM/yyyy HH:mm")
            horaFormatted = format.parse("$data $hora")
        }

        var delay = horaFormatted!!.time-Date().time
        if(delay<0){//se menor que 0, ou seja, indicar uma hora anterior, inverter para rodar somente amanhã
            val today = Date()
            val tomorrow = Date(horaFormatted.time + 1000 * 60 * 60 * 24)
            delay = tomorrow!!.time-today.time
        }
        return delay
    }
}