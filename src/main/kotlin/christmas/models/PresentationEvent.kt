package christmas.models

import christmas.constants.Constants.MINUS_CURRENCY_UNIT
import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.constants.ErrorMessage.INVALID_ORDER_AMOUNT_FOR_PRESENTATION_EVENT
import christmas.constants.Extensions.withCommas

class PresentationEvent(date: Int, private val orderAmount: Int) : Event(date) {
    private val menu: Menu = Menu(MenuItem.CHAMPAGNE, 1)
    override val benefitAmount: Int = menu.amount()

    init {
        require(isValidEventDate(date)) { INVALID_DATE }
        require(isValidOrderAmount()) { INVALID_ORDER_AMOUNT_FOR_PRESENTATION_EVENT }
    }

    override fun toString(): String = "${NAME}: ${MINUS_CURRENCY_UNIT.format(benefitAmount.withCommas())}"

    fun menu() = menu.toString()

    override fun benefitAmount() = benefitAmount

    private fun isValidOrderAmount() = MINIMUM_ORDER_AMOUNT <= orderAmount

    companion object {
        private const val NAME = "증정 이벤트"
        private const val MINIMUM_ORDER_AMOUNT = 120_000
    }
}