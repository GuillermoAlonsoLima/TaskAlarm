package com.example.taskalarm

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.AlarmEditBinding

class EditActivity : AppCompatActivity() {

    var binding: AlarmEditBinding? = null
    var dias = arrayListOf(false,false,false,false,false,false,false)
    var id:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm_edit)

        binding = DataBindingUtil.setContentView(this, R.layout.alarm_edit)

        val titulo1 = intent.getStringExtra("titulo")
        val hora1 = intent.getStringExtra("hora")

        id = intent.getIntExtra("id",0)
        binding!!.tituloTxtEdit.setText(intent.getStringExtra("titulo"))
        binding!!.descricaoTxtEdit.setText(intent.getStringExtra("descricao"))
        binding!!.silenciosoCbEdit.setChecked(intent.getBooleanExtra("silencio",false))
        dias = getBooleanDias(intent.getStringArrayListExtra("dias"))
        binding!!.dataTxtEdit.setText(intent.getStringExtra("data"))
        binding!!.horaTxtEdit.setText(intent.getStringExtra("hora"))
        binding!!.enderecoTxtEdit.setText(intent.getStringExtra("endereco"))

        val titulo  = binding!!.tituloTxtEdit.text.toString()
        val descricao  = binding!!.descricaoTxtEdit.text.toString()
        val silencioso  = binding!!.silenciosoCbEdit.isChecked
        val dias  = getCheckedDias()
        val data  = binding!!.dataTxtEdit.text.toString()
        val hora  = binding!!.horaTxtEdit.text.toString()
        val endereco  = binding!!.enderecoTxtEdit.text.toString()

    }

    fun editar(view: View){
        val titulo  = binding!!.tituloTxtEdit.text.toString()
        val descricao  = binding!!.descricaoTxtEdit.text.toString()
        val silencioso  = binding!!.silenciosoCbEdit.isChecked
        val dias  = getCheckedDias()
        val data  = binding!!.dataTxtEdit.text.toString()
        val hora  = binding!!.horaTxtEdit.text.toString()
        val endereco  = binding!!.enderecoTxtEdit.text.toString()
        MainActivity.alarmes[id!!] = Alarm(titulo,descricao,silencioso,dias,data,hora,endereco,null)
        MainActivity.binding!!.tarefasRvMain.adapter = AlarmAdapter(MainActivity.alarmes,this)
        finish()
    }

    fun cancelar(view: View){
        finish()
    }

    fun switchDia(view: View){
        when(view.id){
            R.id.domingoBtnEdit -> { dias!![0] = !dias!![0] }
            R.id.segundaBtnEdit -> { dias!![1] = !dias!![1] }
            R.id.tercaBtnEdit -> { dias!![2] = !dias!![2] }
            R.id.quartaBtnEdit -> { dias!![3] = !dias!![3] }
            R.id.quintaBtnEdit -> { dias!![4] = !dias!![4] }
            R.id.sextaBtnEdit -> { dias!![5] = !dias!![5] }
            R.id.sabadoBtnEdit -> { dias!![6] = !dias!![6] }
        }
    }

    fun getCheckedDias(): ArrayList<String>{
        val diasNome = arrayListOf("Domingo","Segunda","Terca","Quarta","Quinta","Sexta","Sabado")
        val checkedDias = ArrayList<String>()
        for(i in dias!!.indices){
            if(dias!![i]){
                checkedDias.add(diasNome[i])
            }
        }
        return checkedDias
    }

    fun getBooleanDias(diasVar:ArrayList<String>): ArrayList<Boolean>{
        val booleanDias = arrayListOf(false,false,false,false,false,false,false)
        for(dia in diasVar){
            when(dia){
                "Domingo" -> { booleanDias[0] = true }
                "Segunda" -> { booleanDias[1] = true }
                "Terca" -> { booleanDias[2] = true }
                "Quarta" -> { booleanDias[3] = true }
                "Quinta" -> { booleanDias[4] = true }
                "Sexta" -> { booleanDias[5] = true }
                "Sabado" -> { booleanDias[6] = true }
            }
        }
        return booleanDias
    }
}