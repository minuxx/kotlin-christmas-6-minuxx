package christmas.models

import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.models.Event.Companion.isValidEventDate

class EventDate(private val value: Int) {

    init {
        require(isValidEventDate(value)) { INVALID_DATE }
    }

    fun value() = value
}