package kr.tripstore.proto.presentation.skeleton

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import io.supercharge.shimmerlayout.ShimmerLayout
import kr.tripstore.proto.R
import kotlin.math.floor

object SkeletonBindings {

    @BindingAdapter("shimmer_is_show")
    @JvmStatic
    fun setShimmerShow(shimmerLayout: ShimmerLayout, isShow: Boolean?) {
        isShow?.let {
            if (it) {
                shimmerLayout.alpha = 1f
                shimmerLayout.visibility = View.VISIBLE
                shimmerLayout.startShimmerAnimation()
            } else {
                shimmerLayout.stopShimmerAnimation()
                shimmerLayout.animate().apply {
                    duration = 500
                    alpha(0f)
                    withEndAction() { shimmerLayout.visibility = View.GONE }
                }.start()
            }
        }
    }

    @BindingAdapter("shimmer_item_layout")
    @JvmStatic
    fun setShimmerItemLayout(shimmerLayout: ShimmerLayout, @LayoutRes skeletonItemLayoutId: Int?) {
        skeletonItemLayoutId?.let { itemLayoutId ->
            val measuredHeight =
                getMeasuredHeightOfShimmerItem(shimmerLayout.context, itemLayoutId)

            // Calculate number of child using both the height of device and the height of child view
            shimmerLayout.findViewById<ViewGroup>(R.id.linearlayout_skeleton_container).run {
                val count = getCountOfShimmerItem(shimmerLayout.context, measuredHeight)
                repeat(count) {
                    // Add child view by calculated counts
                    addView(LayoutInflater.from(context).inflate(itemLayoutId, null))
                }
            }
        }
    }

    // FIXME: Inflate a view for measuring, It's just cost, not graceful.
    private fun getMeasuredHeightOfShimmerItem(context: Context, @LayoutRes layoutId: Int) =
        LayoutInflater.from(context).inflate(layoutId, null).run {
            measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            measuredHeight
        }

    private fun getCountOfShimmerItem(context: Context, heightOfShimmerItem: Int): Int =
        if (heightOfShimmerItem > 0) {
            floor(
                context.resources.displayMetrics.heightPixels.toFloat() / heightOfShimmerItem.toFloat()
            ).toInt()
        } else {
            0
        }

}