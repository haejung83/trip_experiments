package kr.tripstore.proto.extension

import androidx.fragment.app.Fragment
import kr.tripstore.proto.TsApplication
import kr.tripstore.proto.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as TsApplication).tripRepository
    return ViewModelFactory(repository)
}
