package com.khaled.boardview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.khaled.boardview.databinding.ViewBoardItemBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class BoardItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewBoardItemBinding =
        ViewBoardItemBinding.inflate(LayoutInflater.from(context), this)

    init {
        setTopLeftCornerSize(4.dp(context))
        setTopRightCornerSize(4.dp(context))
    }

    @ModelProp
    fun setBoardItem(boardItem: BoardItem) {
        binding.itemTitleTv.text = boardItem.title
    }
}
