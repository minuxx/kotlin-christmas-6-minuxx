package christmas.models

import christmas.constants.Constant.EVENT_MONTH
import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import java.time.DateTimeException
import java.time.DayOfWeek.FRIDAY
import java.time.DayOfWeek.SATURDAY
import java.time.LocalDate

class WeekendEvent(private val date: Int, mainMenuCount: Int = 0) : Event(date) {
    override var benefitAmount: Int = mainMenuCount * DISCOUNT_UNIT

    init {
        require(isValidEventDate() && isWeekend()) { INVALID_EVENT_DATE }
    }
    override fun benefitAmount(): Int = benefitAmount

    private fun isWeekend(): Boolean {
        return try {
            val eventDateTime = LocalDate.of(LocalDate.now().year, EVENT_MONTH, date)
            eventDateTime.dayOfWeek == FRIDAY || eventDateTime.dayOfWeek == SATURDAY
        } catch (e: DateTimeException) {
            false
        }
    }

    companion object {
        private const val DISCOUNT_UNIT = 2023
    }
}