package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class ChristmasDayEvent(private val visitDate: Int) {
    private var benefitAmount = PRINCIPAL

    init {
        require(validateEventDate()) { INVALID_EVENT_DATE }
    }

    fun benefitAmount() = benefitAmount

    private fun calculateBenefitAmount() {

    }

    private fun validateEventDate() = visitDate in START_DATE..END_DATE

    companion object {
        const val START_DATE = 1
        const val END_DATE = 25

        private const val PRINCIPAL = 1000
    }
}