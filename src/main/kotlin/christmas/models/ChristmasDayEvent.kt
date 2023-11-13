package christmas.models

class ChristmasDayEvent(private val date: Int) {
    private var benefitAmount = PRINCIPAL

    init {

    }

    fun benefitAmount() = benefitAmount

    private fun calculateBenefitAmount() {

    }

    companion object {
        const val START_DATE = 1
        const val END_DATE = 25

        private const val PRINCIPAL = 1000
    }
}