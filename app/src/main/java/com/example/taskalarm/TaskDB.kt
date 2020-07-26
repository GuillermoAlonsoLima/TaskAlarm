package com.example.taskalarm

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskDB(val context: Context?) :
    SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO) {
    override fun onCreate(db: SQLiteDatabase) {
        val sql = ("CREATE TABLE " + TABELA_TASK + "("
                + ID + " integer primary key autoincrement,"
                + TEXTO + " text,"
                + ALARM_FK + " integer"
                + ")")
        db.execSQL(sql)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABELA_TASK")
        onCreate(db)
    }

    fun getTasks(id:Long):ArrayList<String>{
        val db = this.readableDatabase
        val c: Cursor = db.rawQuery("SELECT * FROM TASK WHERE ALARM_FK = $id", null)
        val tasks = ArrayList<String>()
        if (c.moveToFirst()) {
            do { // Passing values
                tasks.add(c.getString(1))
            } while (c.moveToNext())
        }
        c.close()
        db.close()
        return tasks
    }

    fun execute(sql:String){
        val db = this.readableDatabase
        val sql1 = ("CREATE TABLE IF NOT EXISTS " + TABELA_TASK + "("
                + ID + " integer primary key autoincrement,"
                + TEXTO + " text,"
                + ALARM_FK + " integer"
                + ")")
        db.execSQL(sql1)
        db.execSQL(sql)
    }

    companion object {
        private const val NOME_BANCO = "banco.db"
        private const val TABELA_TASK = "task"
        private const val ID = "_id"
        private const val TEXTO = "texto"
        private const val ALARM_FK = "alarm_fk"
        private const val VERSAO = 1
    }
}