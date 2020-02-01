package kr.tripstore.proto.shared.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Get simple date format for parsing UTC date string
 */
private const val DATE_FORMAT_THEME_CALENDAR = "yyyy-MM-dd HH:mm:ss"
val themeCalendarDateFormat = SimpleDateFormat(DATE_FORMAT_THEME_CALENDAR, Locale.KOREA)
