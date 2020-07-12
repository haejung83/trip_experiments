package kr.tripstore.proto.presentation.resource

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import kr.tripstore.proto.R
import javax.inject.Inject

data class DayOfWeekString(
    val text: String,
    val isHoliday: Boolean
)

interface DayOfWeekStringProvider {
    fun daysOfWeek(): List<DayOfWeekString>
}

@ActivityScoped
class ContextDayOfWeekStringProvider @Inject constructor(
    @ApplicationContext context: Context
) : DayOfWeekStringProvider {

    private val cached: List<DayOfWeekString>

    init {
        context.run {
            cached = listOf(
                DayOfWeekString(
                    getString(R.string.calendar_sunday),
                    true
                ),
                DayOfWeekString(
                    getString(R.string.calendar_monday),
                    false
                ),
                DayOfWeekString(
                    getString(R.string.calendar_tuesday),
                    false
                ),
                DayOfWeekString(
                    getString(R.string.calendar_wednesday),
                    false
                ),
                DayOfWeekString(
                    getString(R.string.calendar_thursday),
                    false
                ),
                DayOfWeekString(
                    getString(R.string.calendar_friday),
                    false
                ),
                DayOfWeekString(
                    getString(R.string.calendar_saturday),
                    true
                )
            )
        }
    }

    override fun daysOfWeek(): List<DayOfWeekString> = cached

}

