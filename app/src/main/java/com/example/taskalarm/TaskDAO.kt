package com.example.taskalarm

import android.content.Context

class TaskDAO(context: Context) {
    val taskDb = TaskDB(context)

    fun adicionar(alarm:Alarm){
        for(tarefa in alarm.tarefas!!){
            taskDb.execute("INSERT INTO TASK (TEXTO,ALARM_FK)"+
            " VALUES('$tarefa',${alarm.id})")
        }
    }

    fun editar(alarm:Alarm){
        taskDb.execute("DELETE FROM TASK WHERE ALARM_FK = ${alarm.id}")
        for(tarefa in alarm.tarefas!!){
            taskDb.execute("INSERT INTO TASK (TEXTO,ALARM_FK)"+
                    " VALUES('$tarefa',${alarm.id})")
        }
    }

    fun deletar(id:Long){
        taskDb.execute("DELETE FROM TASK WHERE _ID = $id")
    }
}