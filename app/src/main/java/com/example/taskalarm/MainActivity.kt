package com.example.taskalarm

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.ActivityMainBinding
import java.sql.Time
import java.time.LocalTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val alarmes = ArrayList<Alarm>()
            alarmes.add(Alarm("teste",null,null,null,null, "11:30",null,null))
            alarmes.add(Alarm("teste2",null,null,null,null, "10:00",null,null))
            alarmes.add(Alarm("teste3",null,null,null,null, "9:15",null,null))

        binding.tarefasRvMain.layoutManager = LinearLayoutManager(this)
        binding.tarefasRvMain.adapter = AlarmAdapter(alarmes)
    }
}
