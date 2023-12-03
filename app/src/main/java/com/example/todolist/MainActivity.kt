package com.example.todolist

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.todolist.databinding.ActivityMainBinding

import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listViewTasks: ListView
    private lateinit var tasksList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTask = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)
        listViewTasks = findViewById(R.id.listViewTasks)

        tasksList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasksList)
        listViewTasks.adapter = adapter

        buttonAdd.setOnClickListener {
            val task = editTextTask.text.toString().trim()
            if (task.isNotEmpty()) {
                tasksList.add(task)
                adapter.notifyDataSetChanged()
                editTextTask.text.clear()
            }
        }

        listViewTasks.setOnItemClickListener { _, _, position, _ ->
            tasksList.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}