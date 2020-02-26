package kr.tripstore.proto.presentation.util

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

object GlideImageBindings {

    @BindingAdapter(
        "glideImageUrl",
        "glideCenterCrop",
        "glideRoundedCorners",
        requireAll = false
    )
    @JvmStatic
    fun loadImageByUrl(
        view: ImageView,
        url: String?,
        centerCrop: Boolean = false,
        roundedCorners: Int = 0
    ) {
        if (url == null) return

        Glide.with(view)
            .load(url)
            .apply {
                transition(DrawableTransitionOptions.withCrossFade())
                if (centerCrop)
                    centerCrop()
                if (roundedCorners != 0)
                    transform(MultiTransformation(CenterCrop(), RoundedCorners(roundedCorners)))
            }.into(view)
    }

    @BindingAdapter(
        "glideImageBitmap",
        "glideCenterCrop",
        "glideRoundedCorners",
        requireAll = false
    )
    @JvmStatic
    fun loadImageByBitmap(
        view: ImageView, bitmap: Bitmap?,
        centerCrop: Boolean = false,
        roundedCorners: Int = 0
    ) {
        if (bitmap == null) return

        Glide.with(view)
            .load(bitmap)
            .apply {
                transition(DrawableTransitionOptions.withCrossFade())
                if (centerCrop)
                    centerCrop()
                if (roundedCorners != 0)
                    transform(MultiTransformation(CenterCrop(), RoundedCorners(roundedCorners)))
            }.into(view)
    }

}