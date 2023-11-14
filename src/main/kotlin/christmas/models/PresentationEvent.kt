package christmas.models

import christmas.constants.ErrorMessage.INVALID_MINIMUM_ORDER_AMOUNT_FOR_PRESENTATION_EVENT

class PresentationEvent(date: Int, private val orderAmount: Int) : Event(date) {
    private val menu: Menu = Menu(MenuItem.CHAMPAGNE, 1)
    override var benefitAmount: Int = menu.amount()

    init {
        require(isValidOrderAmount()) { INVALID_MINIMUM_ORDER_AMOUNT_FOR_PRESENTATION_EVENT }
    }

    fun menu() = menu.toString()

    override fun benefitAmount() = benefitAmount

    private fun isValidOrderAmount() = MINIMUM_ORDER_AMOUNT <= orderAmount

    companion object {
        private const val MINIMUM_ORDER_AMOUNT = 120_000
    }
}