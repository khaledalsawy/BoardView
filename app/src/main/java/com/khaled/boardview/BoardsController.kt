package com.khaled.boardview

import com.airbnb.epoxy.TypedEpoxyController
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class BoardsController(
) : TypedEpoxyController<List<Board>>() {
    override fun buildModels(boards: List<Board>) {
        boards.forEach { board ->
            boardContainerView {
                id(board.id)
                board(board)
            }
        }
    }
}


@ExperimentalCoroutinesApi
class BoardItemsController(
) : TypedEpoxyController<List<BoardItem>>() {
    override fun buildModels(boards: List<BoardItem>) {
        boards.forEach { boardItem ->
            boardItemView {
                id(boardItem.id)
                boardItem(boardItem)
            }
        }
    }
}
