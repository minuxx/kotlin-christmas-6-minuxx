package christmas.models

import christmas.constants.Constant.EVENT_MONTH
import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.LocalDate

class WeekdayEvent(private val date: Int, dessertMenuCount: Int = 0) : Event(date) {
    override var benefitAmount: Int = dessertMenuCount * DISCOUNT_UNIT

    init {
        require(isValidEventDate() && isWeekDay()) { INVALID_EVENT_DATE }
    }

    override fun benefitAmount(): Int = benefitAmount

    private fun isWeekDay(): Boolean {
        return try {
            val eventDateTime = LocalDate.of(LocalDate.now().year, EVENT_MONTH, date)
            eventDateTime.dayOfWeek != DayOfWeek.SATURDAY && eventDateTime.dayOfWeek != DayOfWeek.SUNDAY
        } catch (e: DateTimeException) {
            false
        }
    }

    companion object {
        private const val DISCOUNT_UNIT = 2023
    }
}