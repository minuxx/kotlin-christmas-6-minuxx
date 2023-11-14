package christmas.models

import christmas.constants.Constant.EVENT_MONTH
import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.LocalDate

class WeekendEvent(private val eventDate: Int, private val mainMenuCount: Int = 0) {
    private var calculatedDiscount = 0

    init {
        require(isValidEventDate() && isWeekend()) { INVALID_EVENT_DATE }
        calculatedDiscount = mainMenuCount * DISCOUNT_UNIT
    }

    fun discountAmount() = 0

    private fun isValidEventDate() = eventDate in START_DATE..END_DATE

    private fun isWeekend(): Boolean {
        return try {
            val eventDateTime = LocalDate.of(LocalDate.now().year, EVENT_MONTH, eventDate)
            eventDateTime.dayOfWeek == DayOfWeek.SATURDAY || eventDateTime.dayOfWeek == DayOfWeek.SUNDAY
        } catch (e: DateTimeException) {
            false
        }
    }

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31

        private const val DISCOUNT_UNIT = 2023
    }
}