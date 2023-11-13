package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class ChristmasDayEvent(private val eventDate: Int) {
    private var discountAmount = DISCOUNT_PRINCIPAL

    init {
        require(validateEventDate()) { INVALID_EVENT_DATE }
        discountAmount += (eventDate - START_DATE) * DISCOUNT_UNIT
    }

    fun discountAmount() = discountAmount

    private fun validateEventDate() = eventDate in START_DATE..END_DATE

    companion object {
        const val START_DATE = 1
        const val END_DATE = 25

        private const val DISCOUNT_PRINCIPAL = 1000
        private const val DISCOUNT_UNIT = 100
    }
}