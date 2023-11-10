package christmas.models

import christmas.constants.ErrorMessage

class EventDate(private val value: Int) {

    init {
        require(validateDate()) { ErrorMessage.INVALID_DATE }
    }

    fun value() = value

    private fun validateDate(): Boolean = value in MIN_VALUE..MAX_VALUE

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 31
    }
}