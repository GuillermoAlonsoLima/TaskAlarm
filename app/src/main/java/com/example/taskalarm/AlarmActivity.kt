package com.example.taskalarm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.taskalarm.databinding.AlarmBinding

class AlarmActivity: AppCompatActivity() {

    var binding: AlarmBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm)

        binding = DataBindingUtil.setContentView(this, R.layout.alarm)

        binding!!.horaTxtAlarm.setText(intent.getStringExtra("data")+" "+intent.getStringExtra("hora"))
        binding!!.tituloTxtAlarm.setText(intent.getStringExtra("titulo"))
        binding!!.descricaoTxtAlarm.setText(intent.getStringExtra("descricao"))
        binding!!.fecharAlarmeBtnAlarm.setOnClickListener{
            fechar()
        }
    }

    fun fechar(){
        finish()
    }

}