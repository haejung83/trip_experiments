package kr.tripstore.proto.shared.extension

/**
 * Wrap an array value for passing value to Retrofit2 Query
 */
class ArrayValueWrapper<T> constructor(val value: Array<out T>) {
    override fun toString(): String = value.joinToString(",")
}

/**
 * Array Extension
 */
fun <T> Array<out T>.toArrayValueWrapper(): ArrayValueWrapper<T> = ArrayValueWrapper(this)
