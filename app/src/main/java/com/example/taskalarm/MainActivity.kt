package com.example.taskalarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack2.AlarmAdapter
import com.example.taskalarm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val alarmes = ArrayList<Alarm>()
        var binding: ActivityMainBinding? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        alarmes.add(Alarm("teste",null,null,null,null, "11:30",null,null))
        alarmes.add(Alarm("teste2",null,null,null,null, "10:00",null,null))
        alarmes.add(Alarm("teste3",null,null,null,null, "9:15",null,null))

        binding!!.tarefasRvMain.layoutManager = LinearLayoutManager(this)

        binding!!.tarefasRvMain.adapter = AlarmAdapter(alarmes)
    }

    fun showAdicionar(view: View){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    fun showEditar(view:View){

    }
}
