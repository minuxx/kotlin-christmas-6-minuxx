package christmas.models

import christmas.constants.ErrorMessage

class Date(private val value: Int) {

    init {
        require(validateDate()) { ErrorMessage.DATE_RANGE }
    }

    fun value() = value

    private fun validateDate(): Boolean {
        return true
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 31
    }
}