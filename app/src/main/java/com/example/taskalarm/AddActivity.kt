package com.example.taskalarm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.AlarmAddBinding

class AddActivity: AppCompatActivity() {

    var binding: AlarmAddBinding? = null
    val dias = arrayListOf(false,false,false,false,false,false,false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm_add)

        binding = DataBindingUtil.setContentView(this, R.layout.alarm_add)
    }

    fun adicionar(view:View){
        val titulo  = binding!!.tituloTxtAdd.text.toString()
        val descricao  = binding!!.descricaoTxtAdd.text.toString()
        val silencioso  = binding!!.silenciosoCbAdd.isChecked
        val dias  = getCheckedDias()
        val data  = binding!!.dataTxtAdd.text.toString()
        val hora  = binding!!.horaTxtAdd.text.toString()
        val endereco  = binding!!.enderecoTxtAdd.text.toString()
        MainActivity.alarmes.add(Alarm(titulo,descricao,silencioso,dias,data,hora,endereco,null))
        MainActivity.binding!!.tarefasRvMain.adapter = AlarmAdapter(MainActivity.alarmes)
        finish()
    }

    fun cancelar(view:View){
        finish()
    }

    fun switchDia(view:View){
        when(view.id){
            R.id.domingoBtnAdd -> { dias[0] = !dias[0] }
            R.id.segundaBtnAdd -> { dias[1] = !dias[1] }
            R.id.tercaBtnAdd -> { dias[2] = !dias[2] }
            R.id.quartaBtnAdd -> { dias[3] = !dias[3] }
            R.id.quintaBtnAdd -> { dias[4] = !dias[4] }
            R.id.sextaBtnAdd -> { dias[5] = !dias[5] }
            R.id.sabadoBtnAdd -> { dias[6] = !dias[6] }
        }
    }

    fun getCheckedDias(): ArrayList<String>{
        val diasNome = arrayListOf("Domingo","Segunda","Terca","Quarta","Quinta","Sexta","Sabado")
        val checkedDias = ArrayList<String>()
        for(i in dias.indices){
            if(dias[i]){
                checkedDias.add(diasNome[i])
            }
        }
        return checkedDias
    }


}