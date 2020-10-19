package com.myweb.lab10sqlite

import DatabaseHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_delete.*

class EditDeleteActivity : AppCompatActivity() {
    private lateinit var dbHandler:DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_delete)

        dbHandler = DatabaseHelper.getInstance(baseContext)
        val mID :String? = intent.getStringExtra("mId")
        val mName :String? = intent.getStringExtra("mName")
        val mAge :String? = intent.getStringExtra("mAge")

        edt_id.setText(mID)
        edt_id.isEnabled = false
        edt_name.setText(mName)
        edt_age.setText(mAge)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateStudent(v: View){
        var id :String = edt_id.text.toString()
        var name :String = edt_name.text.toString()
        var age :Int = edt_age.text.toString().toInt()
        var result :Int = dbHandler.updateStudent(Student(id=id,name=name,age=age))
        if(result > -1){
            Toast.makeText(applicationContext, "The Student is updated successfully", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext,"Insert Failure",Toast.LENGTH_LONG).show()
        }
        finish()
    }
}