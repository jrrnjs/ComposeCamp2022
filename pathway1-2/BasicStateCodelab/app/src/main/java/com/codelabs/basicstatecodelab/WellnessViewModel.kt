package com.codelabs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelabs.basicstatecodelab.model.WellnessTask

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskChecked(task: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == task.id }?.let { task ->
            task.checked = checked
        }
    }

    private fun getWellnessTasks(): List<WellnessTask> {
        return List(30) { index ->
            WellnessTask(index, "Task # $index")
        }
    }
}
