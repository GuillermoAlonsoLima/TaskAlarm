package com.example.taskalarm

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.AlarmEditBinding

class EditActivity : AppCompatActivity() {

    var binding: AlarmEditBinding? = null
    var dias = arrayListOf(false,false,false,false,false,false,false)
    var id:Long? = null
    val alarmDAO = AlarmDAO(this)

    companion object{
        var tarefas:ArrayList<String> = ArrayList()
        var tasksRv:RecyclerView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm_edit)

        binding = DataBindingUtil.setContentView(this, R.layout.alarm_edit)

        id = intent.getLongExtra("id",0)
        binding!!.tituloTxtEdit.setText(intent.getStringExtra("titulo"))
        binding!!.descricaoTxtEdit.setText(intent.getStringExtra("descricao"))
        binding!!.silenciosoCbEdit.setChecked(intent.getBooleanExtra("silencio",false))
        if(intent.getStringArrayListExtra("dias") != null){
            dias =  getBooleanDias(intent.getStringArrayListExtra("dias"))
        }
        binding!!.dataTxtEdit.setText(intent.getStringExtra("data"))
        binding!!.horaTxtEdit.setText(intent.getStringExtra("hora"))
        binding!!.enderecoTxtEdit.setText(intent.getStringExtra("endereco"))

        binding!!.tasksRvEdit.layoutManager = LinearLayoutManager(this)
        if(intent.getStringArrayListExtra("tarefas") != null){
            tarefas = intent.getStringArrayListExtra("tarefas")
        }
        binding!!.tasksRvEdit.adapter = TaskAdapterEdit(tarefas)
        tasksRv = binding!!.tasksRvEdit

        turnDias()
    }

    fun editar(view: View){
        val titulo  = binding!!.tituloTxtEdit.text.toString()
        val descricao  = binding!!.descricaoTxtEdit.text.toString()
        val silencioso  = binding!!.silenciosoCbEdit.isChecked
        val dias  = getCheckedDias()
        val data  = binding!!.dataTxtEdit.text.toString()
        val hora  = binding!!.horaTxtEdit.text.toString()
        val endereco  = binding!!.enderecoTxtEdit.text.toString()
        alarmDAO.editar(Alarm(
            id!!,
            titulo,
            descricao,
            silencioso,
            dias,
            data,
            hora,
            endereco,
            tarefas,
            this
        ))
        MainActivity.binding!!.tarefasRvMain.adapter = AlarmAdapter(alarmDAO.selecionarTudo(),this)
        finish()
    }

    fun deletar(view:View){
        alarmDAO.deletar(id!!)
        MainActivity.binding!!.tarefasRvMain.adapter = AlarmAdapter(alarmDAO.selecionarTudo(),this)
        finish()
    }

    fun cancelar(view: View){
        finish()
    }

    fun adicionarTarefa(view:View){
        tarefas.add(binding!!.tarefaTxtEdit.text.toString())
        binding!!.tasksRvEdit.adapter = TaskAdapterEdit(tarefas)
        binding!!.tarefaTxtEdit.setText("")
    }

    fun switchDia(view:View){
        when(view.id){
            R.id.domingoBtnEdit -> {
                dias[0] = !dias[0]
                if(dias[0]) binding!!.domingoBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.domingoBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
            R.id.segundaBtnEdit -> {
                dias[1] = !dias[1]
                if(dias[1]) binding!!.segundaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.segundaBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
            R.id.tercaBtnEdit -> {
                dias[2] = !dias[2]
                if(dias[2]) binding!!.tercaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.tercaBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
            R.id.quartaBtnEdit -> {
                dias[3] = !dias[3]
                if(dias[3]) binding!!.quartaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.quartaBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
            R.id.quintaBtnEdit -> {
                dias[4] = !dias[4]
                if(dias[4]) binding!!.quintaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.quintaBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
            R.id.sextaBtnEdit -> {
                dias[5] = !dias[5]
                if(dias[5]) binding!!.sextaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.sextaBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
            R.id.sabadoBtnEdit -> {
                dias[6] = !dias[6]
                if(dias[6]) binding!!.sabadoBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                else binding!!.sabadoBtnEdit.setBackgroundColor(Color.parseColor("#3F51B5"))
            }
        }
    }
    fun turnDias(){
        for(i in dias!!.indices) {
            when (i) {
                0 -> {
                    if (dias[0]) binding!!.domingoBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
                1 -> {
                    if (dias[1]) binding!!.segundaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
                2 -> {
                    if (dias[2]) binding!!.tercaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
                3 -> {
                    if (dias[3]) binding!!.quartaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
                4 -> {
                    if (dias[4]) binding!!.quintaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
                5 -> {
                    if (dias[5]) binding!!.sextaBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
                6 -> {
                    if (dias[6]) binding!!.sabadoBtnEdit.setBackgroundColor(Color.parseColor("#FF2196F3"))
                }
            }
        }
    }

    fun getCheckedDias(): ArrayList<String>{
        val diasNome = arrayListOf("domingo","segunda","terca","quarta","quinta","sexta","sabado")
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
                "domingo" -> { booleanDias[0] = true }
                "segunda" -> { booleanDias[1] = true }
                "terca" -> { booleanDias[2] = true }
                "quarta" -> { booleanDias[3] = true }
                "quinta" -> { booleanDias[4] = true }
                "sexta" -> { booleanDias[5] = true }
                "sabado" -> { booleanDias[6] = true }
            }
        }
        return booleanDias
    }
}