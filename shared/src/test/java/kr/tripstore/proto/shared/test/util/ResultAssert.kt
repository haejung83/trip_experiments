package kr.tripstore.proto.shared.test.util

import kr.tripstore.proto.shared.result.Result
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull

fun assertResult(result: Any?) {
    assertThat(result, IsNull.notNullValue())
    assertThat(result, IsInstanceOf.instanceOf(Result.Success::class.java))
}