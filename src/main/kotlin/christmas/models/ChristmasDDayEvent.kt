package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class ChristmasDDayEvent(private val date: Int) {
    private var calculatedDiscount = DISCOUNT_PRINCIPAL

    init {
        require(isValidEventDate()) { INVALID_EVENT_DATE }
        calculatedDiscount += (date - START_DATE) * DISCOUNT_UNIT
    }

    fun discountAmount() = calculatedDiscount

    private fun isValidEventDate() = date in START_DATE..END_DATE

    companion object {
        const val START_DATE = 1
        const val END_DATE = 25

        private const val DISCOUNT_PRINCIPAL = 1000
        private const val DISCOUNT_UNIT = 100
    }
}