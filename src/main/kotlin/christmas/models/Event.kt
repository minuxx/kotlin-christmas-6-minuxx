package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

abstract class Event(private val date: Int) {
    protected abstract var benefitAmount: Int

    init {
        require(isInvalidEventDate()) { INVALID_EVENT_DATE }
    }

    abstract fun benefitAmount(): Int

    private fun isInvalidEventDate() = date in START_DATE..END_DATE

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
        const val CHRISTMAS_D_DAY = 25
    }
}