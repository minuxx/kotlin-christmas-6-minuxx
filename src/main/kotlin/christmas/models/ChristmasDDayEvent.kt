package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class ChristmasDDayEvent(date: Int) : Event(date) {
    override var benefitAmount: Int = DISCOUNT_PRINCIPAL

    init {
        benefitAmount += (date - START_DATE) * DISCOUNT_UNIT
    }

    override fun benefitAmount() = benefitAmount

    companion object {
        private const val DISCOUNT_PRINCIPAL = 1000
        private const val DISCOUNT_UNIT = 100
    }
}