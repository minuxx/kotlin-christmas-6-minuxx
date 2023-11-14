package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import christmas.constants.ErrorMessage.INVALID_MINIMUM_ORDER_AMOUNT_FOR_PRESENTATION_EVENT

class PresentationEvent(private val date: Int, private val orderAmount: Int) {
    private val menu: Menu = Menu(MenuItem.CHAMPAGNE, 1)

    init {
        require(isValidEventDate()) { INVALID_EVENT_DATE }
        require(isValidOrderAmount()) { INVALID_MINIMUM_ORDER_AMOUNT_FOR_PRESENTATION_EVENT }
    }

    fun menu() = menu.toString()

    fun benefitAmount() = menu.amount()

    private fun isValidEventDate() = date in START_DATE..END_DATE

    private fun isValidOrderAmount() = MINIMUM_ORDER_AMOUNT <= orderAmount

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31

        private const val MINIMUM_ORDER_AMOUNT = 120_000
    }
}