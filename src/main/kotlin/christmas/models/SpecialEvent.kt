package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class SpecialEvent(private val date: Int) {
    private var calculatedDiscount = DISCOUNT_AMOUNT

    init {
        require(isValidSpecialDate()) { INVALID_EVENT_DATE }
    }

    fun discountAmount() = calculatedDiscount

    private fun isValidSpecialDate() = (date in START_DATE..END_DATE) && date in specialDates

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
        private val specialDates = setOf(3, 10, 17, 24, 25, 31)

        private const val DISCOUNT_AMOUNT = 1000
    }
}