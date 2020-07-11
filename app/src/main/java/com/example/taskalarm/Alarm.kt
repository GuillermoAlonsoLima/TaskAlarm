package com.example.taskalarm

import android.content.Context
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timerTask


class Alarm(
    titulo: String,
    descricao: String?,
    silencio: Boolean?,
    dias: ArrayList<String>?,
    data: String?,
    hora: String,
    endereco: String?,
    tarefas: ArrayList<String>?,
    context: Context
) {
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
        var format:SimpleDateFormat? = null
        var horaFormatted:Date? = null
        if(data == null){
            format = SimpleDateFormat("dd/MM/yyyy")
            val currentDate = format.format(Date())
            format = SimpleDateFormat("dd/MM/yyyy HH:mm")
            horaFormatted = format.parse("$currentDate $hora")
        }else{
            format = SimpleDateFormat("dd/MM/yyyy HH:mm")
            horaFormatted = format.parse("$data $hora")
        }

        val testeHora = format!!.format(horaFormatted)
        var delay = horaFormatted!!.time-Date().time
        if(delay<0){//se menor que 0, ou seja, indicar uma hora anterior, inverter para rodar somente amanhã
            val today = Date()
            val tomorrow = Date(horaFormatted.time + 1000 * 60 * 60 * 24)
            delay = tomorrow!!.time-today.time
        }
        timer.schedule(timerTask {
            val intent = Intent(context, AlarmActivity::class.java).apply {
                putExtra("data",data)
                putExtra("hora",hora)
                putExtra("titulo",titulo)
                putExtra("descricao",descricao)
            }
            context.startActivity(intent)
        }, delay)
    }
}