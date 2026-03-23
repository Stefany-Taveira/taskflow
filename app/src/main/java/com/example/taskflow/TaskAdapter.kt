package com.example.taskflow

import kotlin.collections.get


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskflow.databinding.ItemTaskBinding

class TaskAdapter(private val tasks: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]

        holder.binding.textTask.text = task.title

        holder.binding.checkbox.setOnCheckedChangeListener(null)
        holder.binding.checkbox.isChecked = task.isDone

        holder.binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            task.isDone = isChecked
        }

        holder.binding.btnDelete.setOnClickListener {
            tasks.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, tasks.size)
        }
    }

    override fun getItemCount(): Int = tasks.size
}