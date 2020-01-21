package kr.tripstore.proto.test.data

import kr.tripstore.proto.model.*
import kotlin.random.Random

@Suppress("UNUSED", "MemberVisibilityCanBePrivate")
object TestData {

    // Constants
    private const val EMPTY_STRING = ""
    private const val NO_ERROR = 0
    private const val TRIP_PACKAGE_BASE_ID = 100
    private const val TRIP_DETAIL_BASE_ID = 10000

    private val NO_ERRORS = null
    private val RESPONSE_TIME = Random.nextDouble(0.005, 0.9)

    // TripPackagePage
    val tripPackagePageFilter = TripPackagePageFilter("false", "false")
    val tripDetail = TripDetail(
        TRIP_DETAIL_BASE_ID + 1,
        "옥토끼",
        "https://pm1.narvii.com/6227/b25863e007813fdd18a2d4ebe0d624d37471f939_hq.jpg",
        "점프",
        EMPTY_STRING
    )
    val tripPackage = TripPackage(
        TRIP_PACKAGE_BASE_ID + 1,
        "달나라",
        "TIME_SALE",
        tripDetails = listOf(tripDetail)
    )
    val tripPackagePage = TripPackagePage(
        RESPONSE_TIME,
        NO_ERROR,
        NO_ERRORS,
        30,
        0,
        30,
        false,
        30,
        tripPackagePageFilter,
        listOf(tripPackage)
    )
    // Empty TripPackagePage
    val emptyTripPackage = TripPackage(
        TRIP_PACKAGE_BASE_ID + 0,
        "없음",
        "NONE",
        false,
        emptyList()
    )
    val emptyTripPackagePage = TripPackagePage(
        RESPONSE_TIME,
        NO_ERROR,
        NO_ERRORS,
        0,
        0,
        0,
        false,
        0,
        tripPackagePageFilter,
        emptyList()
    )
    // Calendars
    val calendarDays = (10..20).toList().map {
        CalendarDay("2020-01-$it", Random.nextInt(100_000, 900_000), false)
    }
    val calendars = Calendars(
        RESPONSE_TIME,
        NO_ERROR,
        NO_ERRORS,
        calendarDays
    )

}