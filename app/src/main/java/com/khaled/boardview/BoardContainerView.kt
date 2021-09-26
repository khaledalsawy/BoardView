package com.khaled.boardview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.khaled.boardview.databinding.ViewBoardContainerBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
private val controller = BoardItemsController()

@ExperimentalCoroutinesApi
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_MATCH_HEIGHT)
class BoardContainerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewBoardContainerBinding =
        ViewBoardContainerBinding.inflate(LayoutInflater.from(context), this)

    init {
        binding.itemsRv.setController(controller)
        setAllCornersRadius(12.dp(context))
        setBackgroundColorRes(R.color.white)
    }

    @ModelProp
    fun setBoard(board: Board) {
        binding.boardTitleTv.text = board.title
        controller.setData(emptyList())
        controller.setData(board.items)
    }
}
