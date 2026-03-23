package com.example.taskflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = TaskAdapter(taskList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val title = binding.inputTask.text.toString()
            if (title.isNotEmpty()) {
                val task = Task(title)
                taskList.add(task)
                adapter.notifyItemInserted(taskList.size - 1)
                binding.inputTask.text.clear()
            }
        }
    }
}