package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class SpecialEvent(private val eventDate: Int) {
    private var calculatedDiscount = DISCOUNT_UNIT

    init {
        require(isValidSpecialDate()) { INVALID_EVENT_DATE }
    }

    fun discountAmount() = calculatedDiscount

    private fun isValidSpecialDate() = (eventDate in START_DATE..END_DATE) && eventDate in specialDates

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
        private val specialDates = listOf(3, 10, 17, 24, 25, 31)

        private const val DISCOUNT_UNIT = 1000
    }
}