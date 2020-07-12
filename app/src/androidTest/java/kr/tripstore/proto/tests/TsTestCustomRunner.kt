package kr.tripstore.proto.tests

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(TsTestApplication::class)
class TsTestCustomRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TsTestCustomRunner_Application::class.java.name, context)
    }

}