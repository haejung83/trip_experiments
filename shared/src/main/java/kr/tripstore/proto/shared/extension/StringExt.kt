package kr.tripstore.proto.shared.extension

private const val PRIVATE_CONST_COMMA = ","
private const val PRIVATE_CONST_EMPTY = ""

val String.Companion.empty: String
    get() = PRIVATE_CONST_EMPTY

fun String.splitByComma() = split(PRIVATE_CONST_COMMA)

fun String.splitAndGetIntArrayByComma() = splitByComma().map { it.toInt() }
