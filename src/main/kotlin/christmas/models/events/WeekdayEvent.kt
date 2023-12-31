package christmas.models.events

import christmas.constants.Constants.MINUS_CURRENCY_UNIT
import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.constants.Extensions.withCommas
import java.time.DateTimeException
import java.time.DayOfWeek.FRIDAY
import java.time.DayOfWeek.SATURDAY
import java.time.LocalDate

class WeekdayEvent(private val date: Int, dessertMenuCount: Int) : Event() {
    override val benefitAmount: Int = dessertMenuCount * DISCOUNT_UNIT

    init {
        require(isValidEventDate(date) && isWeekDay()) { INVALID_DATE }
    }

    override fun toString(): String = "$NAME: ${MINUS_CURRENCY_UNIT.format(benefitAmount.withCommas())}"

    override fun benefitAmount(): Int = benefitAmount

    private fun isWeekDay(): Boolean {
        return try {
            val eventDateTime = LocalDate.of(LocalDate.now().year, MONTH, date)
            eventDateTime.dayOfWeek != FRIDAY && eventDateTime.dayOfWeek != SATURDAY
        } catch (e: DateTimeException) {
            false
        }
    }

    companion object {
        private const val NAME = "평일 할인"
        private const val DISCOUNT_UNIT = 2_023
    }
}