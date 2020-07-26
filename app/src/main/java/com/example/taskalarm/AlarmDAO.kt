package com.example.taskalarm

import android.content.Context

class AlarmDAO(context: Context) {

    val alarmDB = AlarmDB(context)
    val taskDAO = TaskDAO(context)

    fun adicionar(alarm:Alarm){
        val dias = if(alarm.dias != null) getDias(alarm.dias!!) else arrayListOf(0,0,0,0,0,0,0)
        val silencio = if(alarm.silencio!!) 1 else 0
        alarmDB.execute("INSERT INTO ALARM(TITULO,DESCRICAO,SILENCIO,DOMINGO,SEGUNDA,TERCA,QUARTA,QUINTA,SEXTA,SABADO,DATA,HORA,ENDERECO)"
        +" VALUES ('${alarm.titulo}','${alarm.descricao}',$silencio,${dias[0]},${dias[1]},${dias[2]},${dias[3]},${dias[4]},${dias[5]},${dias[6]},'${alarm.data}','${alarm.hora}','${alarm.endereco}')")
        taskDAO.adicionar(alarm)
    }

    fun editar(alarm:Alarm){
        val dias = if(alarm.dias != null) getDias(alarm.dias!!) else arrayListOf(0,0,0,0,0,0,0)
        val silencio = if(alarm.silencio!!) 1 else 0
        alarmDB.execute("UPDATE ALARM"+
        " SET TITULO='${alarm.titulo}',"+
        "DESCRICAO='${alarm.descricao}',"+
        "SILENCIO=$silencio,"+
        "DOMINGO=${dias[0]},"+
        "SEGUNDA=${dias[1]},"+
        "TERCA=${dias[2]},"+
        "QUARTA=${dias[3]},"+
        "QUINTA=${dias[4]},"+
        "SEXTA=${dias[5]},"+
        "SABADO=${dias[6]},"+
        "DATA='${alarm.data}',"+
        "HORA='${alarm.hora}',"+
        "ENDERECO='${alarm.endereco}' "+
        "WHERE _ID = ${alarm.id}")
        taskDAO.editar(alarm)
    }

    fun deletar(id:Long){
        alarmDB.execute("DELETE FROM ALARM WHERE _ID = $id")
        taskDAO.deletar(id)
    }

    fun selecionar(alarm:Alarm):Alarm{
        return alarmDB.select("SELECT * FROM ALARM WHERE _ID = ${alarm.id}")[0]
    }

    fun selecionarTudo():ArrayList<Alarm>{
        return alarmDB.select("SELECT * FROM ALARM")
    }

    private fun getDias(dias:ArrayList<String>):ArrayList<Int>{
        val diasNome = arrayListOf("domingo","segunda","terca","quarta","quinta","sexta","sabado")
        val diasBoolean = arrayListOf(0,0,0,0,0,0,0)
        for(dia in dias){
            when(dia){
                "domingo"->{
                    diasBoolean[0] = 1
                }
                "segunda"->{
                    diasBoolean[1] = 1
                }
                "terca"->{
                    diasBoolean[2] = 1
                }
                "quarta"->{
                    diasBoolean[3] = 1
                }
                "quinta"->{
                    diasBoolean[4] = 1
                }
                "sexta"->{
                    diasBoolean[5] = 1
                }
                "sabado"->{
                    diasBoolean[6] = 1
                }
            }
        }
        return diasBoolean
    }

}