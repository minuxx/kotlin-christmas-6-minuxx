package christmas.models

import christmas.constants.Constant.EVENT_MONTH
import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import java.time.DateTimeException
import java.time.DayOfWeek.FRIDAY
import java.time.DayOfWeek.SATURDAY
import java.time.LocalDate

class WeekdayEvent(private val date: Int, dessertMenuCount: Int) : Event(date) {
    override val benefitAmount: Int = dessertMenuCount * DISCOUNT_UNIT

    init {
        require(isValidEventDate() && isWeekDay()) { INVALID_EVENT_DATE }
    }

    override fun benefitAmount(): Int = benefitAmount

    private fun isWeekDay(): Boolean {
        return try {
            val eventDateTime = LocalDate.of(LocalDate.now().year, EVENT_MONTH, date)
            eventDateTime.dayOfWeek != FRIDAY && eventDateTime.dayOfWeek != SATURDAY
        } catch (e: DateTimeException) {
            false
        }
    }

    companion object {
        private const val DISCOUNT_UNIT = 2023
    }
}