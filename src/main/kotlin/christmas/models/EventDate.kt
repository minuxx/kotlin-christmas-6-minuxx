package christmas.models

import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.models.Event.Companion.END_DATE
import christmas.models.Event.Companion.START_DATE

class EventDate(private val value: Int) {

    init {
        require(isValidEventDate()) { INVALID_DATE }
    }

    fun value() = value

    private fun isValidEventDate(): Boolean = value in START_DATE..END_DATE
}