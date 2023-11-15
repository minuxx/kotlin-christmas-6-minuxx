package christmas.models.events

import christmas.constants.Constants.MINUS_CURRENCY_UNIT
import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.constants.Extensions.withCommas

class ChristmasDDayEvent(private val date: Int) : Event() {
    override val benefitAmount: Int = DISCOUNT_PRINCIPAL + (date - START_DATE) * DISCOUNT_UNIT

    init {
        require(isValidEventDate(date) && isValidChristmasEventDate()) { INVALID_DATE }
    }

    override fun toString(): String = "$NAME: ${MINUS_CURRENCY_UNIT.format(benefitAmount.withCommas())}"

    override fun benefitAmount() = benefitAmount

    private fun isValidChristmasEventDate() = date in START_DATE..CHRISTMAS_D_DAY

    companion object {
        private const val NAME = "크리스마스 디데이 할인"
        private const val CHRISTMAS_D_DAY = 25
        private const val DISCOUNT_PRINCIPAL = 1_000
        private const val DISCOUNT_UNIT = 100
    }
}