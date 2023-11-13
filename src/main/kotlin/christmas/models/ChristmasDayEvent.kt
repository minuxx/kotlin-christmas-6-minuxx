package christmas.models

class ChristmasDayEvent(private val visitDate: Int) {
    private var benefitAmount = PRINCIPAL

    init {

    }

    fun benefitAmount() = benefitAmount

    private fun calculateBenefitAmount() {

    }

    private fun validateEventDate() = false

    companion object {
        const val START_DATE = 1
        const val END_DATE = 25

        private const val PRINCIPAL = 1000
    }
}