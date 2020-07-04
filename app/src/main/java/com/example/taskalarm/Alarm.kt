package com.example.taskalarm

import kotlin.collections.ArrayList

class Alarm(titulo:String, descricao:String?, silencio:Boolean?, dias:ArrayList<String>?, data: String?, hora: String,endereco:String?,tarefas:ArrayList<String>?) {
    var titulo = titulo
    var descricao = descricao
    var silencio = silencio
    var dias = dias
    var data = data
    var hora = hora
    var endereco = endereco
    var tarefas = tarefas
}