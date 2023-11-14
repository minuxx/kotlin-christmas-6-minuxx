package christmas.models

class SpecialEvent(private val eventDate: Int) {
    private var calculatedDiscount = DISCOUNT_UNIT

    init {

    }

    fun discountAmount() = calculatedDiscount

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31

        private const val DISCOUNT_UNIT = 1000
    }
}