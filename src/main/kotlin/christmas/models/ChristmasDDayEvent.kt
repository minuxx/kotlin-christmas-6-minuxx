package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class ChristmasDDayEvent(private val date: Int) : Event(date) {
    override var benefitAmount: Int = DISCOUNT_PRINCIPAL + (date - START_DATE) * DISCOUNT_UNIT

    init {
        require(isValidChristmasEventDate()) { INVALID_EVENT_DATE }
    }

    override fun benefitAmount() = benefitAmount

    private fun isValidChristmasEventDate() = date in START_DATE..CHRISTMAS_D_DAY

    companion object {
        private const val CHRISTMAS_D_DAY = 25
        private const val DISCOUNT_PRINCIPAL = 1_000
        private const val DISCOUNT_UNIT = 100
    }
}