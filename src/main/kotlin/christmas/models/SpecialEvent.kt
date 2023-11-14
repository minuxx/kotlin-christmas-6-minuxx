package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import christmas.constants.Extensions.withCommas

class SpecialEvent(private val date: Int) : Event(date) {
    override val benefitAmount: Int = DISCOUNT_AMOUNT

    init {
        require(isSpecialDate()) { INVALID_EVENT_DATE }
    }

    override fun toString(): String = "${NAME}: -${benefitAmount.withCommas()}"

    override fun benefitAmount() = benefitAmount

    private fun isSpecialDate() = date in specialDates

    companion object {
        private const val NAME = "특별 할인"
        private val specialDates = setOf(3, 10, 17, 24, 25, 31)
        private const val DISCOUNT_AMOUNT = 1000
    }
}