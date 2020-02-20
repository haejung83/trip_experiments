package kr.tripstore.proto.presentation.util

import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

object GlideImageBindings {

    @BindingAdapter("glideImage")
    @JvmStatic
    fun loadImage(view: ImageView, source: Any?) {
        source?.let {
            Glide.with(view)
                .load(it)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }

    @BindingAdapter("glideImageUri")
    @JvmStatic
    fun loadImageByUri(view: ImageView, uri: Uri?) {
        uri?.let {
            Glide.with(view)
                .load(it)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }

    @BindingAdapter("glideImageUrl")
    @JvmStatic
    fun loadImageByUrl(view: ImageView, url: String?) {
        url?.let {
            Glide.with(view)
                .load(it)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }

    @BindingAdapter("glideImageBitmap")
    @JvmStatic
    fun loadImageByBitmap(view: ImageView, bitmap: Bitmap?) {
        bitmap?.let {
            Glide.with(view)
                .load(it)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
        }
    }
}