package christmas.models

import christmas.constants.Constants.MINUS_CURRENCY_UNIT
import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.constants.Extensions.withCommas
import java.time.DateTimeException
import java.time.DayOfWeek.FRIDAY
import java.time.DayOfWeek.SATURDAY
import java.time.LocalDate

class WeekendEvent(private val date: Int, mainMenuCount: Int) : Event(date) {
    override val benefitAmount: Int = (mainMenuCount * DISCOUNT_UNIT)

    init {
        require(isValidEventDate(date) && isWeekend()) { INVALID_DATE }
    }

    override fun toString(): String = "${NAME}: ${MINUS_CURRENCY_UNIT.format(benefitAmount.withCommas())}"

    override fun benefitAmount(): Int = benefitAmount

    private fun isWeekend(): Boolean {
        return try {
            val eventDateTime = LocalDate.of(LocalDate.now().year, MONTH, date)
            eventDateTime.dayOfWeek == FRIDAY || eventDateTime.dayOfWeek == SATURDAY
        } catch (e: DateTimeException) {
            false
        }
    }

    companion object {
        private const val NAME = "주말 할인"
        private const val DISCOUNT_UNIT = 2_023
    }
}