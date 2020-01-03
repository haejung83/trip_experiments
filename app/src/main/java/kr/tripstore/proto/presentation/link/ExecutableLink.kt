package kr.tripstore.proto.presentation.link

import timber.log.Timber

class ExecutableLink(private val message: String = "Nothing") {

    fun execute() {
        Timber.d(message)
    }

}