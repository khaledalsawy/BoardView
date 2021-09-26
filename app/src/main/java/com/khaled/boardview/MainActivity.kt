package com.khaled.boardview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.khaled.boardview.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupBoards()

    }


    private val controller: BoardsController = BoardsController()
    var layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    private fun setupBoards() {
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(  binding.boardRv)

        binding.boardRv.setController(controller)
        binding.boardRv.layoutManager = layoutManager
        controller.setData(generateDummy())
    }


    private fun generateDummy(): List<Board> {
        return listOf(
            Board("1", "TO-DO", "#fffffff", "Test", generateDummyTasks(10)),
            Board("2", "IN PROGRESS", "#fffffff", "Test", generateDummyTasks(20)),
            Board("3", "COMPLETED", "#fffffff", "Test", generateDummyTasks(5)),
            Board("4", "HOLD", "#fffffff", "Test", generateDummyTasks(2)),
            Board("5", "ENDED", "#fffffff", "Test", generateDummyTasks(40))
        )
    }

    private fun generateDummyTasks(count: Int): List<BoardItem> {
        val tasks: MutableList<BoardItem> = mutableListOf()
        for (i in 0..count) {
            tasks.add(BoardItem(i.toString(), "Task - $i", "Test"))
        }
        return tasks
    }

}