package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

abstract class Event(private val date: Int) {
    protected abstract val benefitAmount: Int

    abstract fun benefitAmount(): Int
    fun isValidEventDate(): Boolean = date in START_DATE..END_DATE

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
    }
}