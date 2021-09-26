package com.khaled.boardview

data class Board(
    val id: String,
    val title: String,
    val colorCode: String,
    val description: String,
    val items: List<BoardItem>
)

data class BoardItem(
    val id: String,
    val title: String,
    val description: String
)