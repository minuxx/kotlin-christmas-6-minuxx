package christmas.models

class WeekdayEvent(private val eventDate: Int, private val dessertMenuCount: Int = 0) {
    private var calculatedDiscount = 0

    init {

    }

    fun discountAmount() = calculatedDiscount

    companion object {
        const val MONTH = 12
        const val START_DATE = 1
        const val END_DATE = 31
    }
}