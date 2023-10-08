package com.example.room_database_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.room_database_2.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var studentDatabase: StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            saveData()
        }
        binding.Btnsearch.setOnClickListener {
            searchData()
        }
        binding.Delete.setOnClickListener {

        }

    }


    private fun searchData() {

    }

    private fun saveData() {
        val firstName = binding.firstname.text.toString()
        val lastName = binding.lastname.text.toString()
        val rollNo = binding.edroll.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()) {
            val student = Student(null, firstName, lastName, rollNo.toInt())
            GlobalScope.launch (Dispatchers.IO){
                studentDatabase.studentDao().insert(student)
            }
            binding.firstname.text.clear()
            binding.lastname.text.clear()
            binding.edroll.text.clear()

            Toast.makeText(this, "Data Save", Toast.LENGTH_SHORT).show()
        }
       else{

            Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show()}
    }
}

