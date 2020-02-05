package kr.tripstore.proto.presentation.calendar

import android.widget.FrameLayout
import androidx.databinding.BindingAdapter

object CalendarBindings {

    @BindingAdapter("heightOfSpace")
    @JvmStatic
    fun setHeightOfSpace(frameLayout: FrameLayout, heightOfSpace: Int?) {
        heightOfSpace?.let {
            frameLayout.layoutParams.height = heightOfSpace
        }
    }

}