package com.alvin.tugas8alvin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME = "MyDB"
val TABLE_NAME = "User1"
val COL_NAME = "name"
val COL_EMAIL = "email"
val TELPON = "telp"
val ALAMAT = "alamat"
val COL_ID = "id"


class  DatabaseHendler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTabel = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COL_NAME + " VARCHAR(256),"+
                COL_EMAIL + " VARCHAR(256)," +
                TELPON + " INTEGER," +
                ALAMAT + " VARCHAR(256))"

        db?.execSQL(createTabel)
    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun insertData(user : User){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_EMAIL, user.email)
        cv.put(TELPON, user.telpon)
        cv.put(ALAMAT, user.alamat)
       var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong()){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Succes",Toast.LENGTH_SHORT).show()
        }
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(0).toInt()
                user.name = result.getString(1)
                user.email = result.getString(2)
                user.telpon = result.getString(3).toInt()
                user.alamat = result.getString(4)
                list.add(user)
            }while (result.moveToNext())
        }


        result.close()
        db.close()
        return  list
    }

    fun deleteData(user : User){
        val db = this.readableDatabase
        db.delete(TABLE_NAME, COL_ID+"=?", arrayOf(user.id.toString()))
        db.close()
    }

}