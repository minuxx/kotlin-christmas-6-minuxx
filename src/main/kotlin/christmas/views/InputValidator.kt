package christmas.views

import christmas.constants.ErrorMessage

class InputValidator {
    fun validateDateInput(input: String): Int {
        val trimmedInput = input.trim()
        val isValid = isNotEmptyOrBlank(trimmedInput) && isDigitAll(trimmedInput)

        require(isValid) { ErrorMessage.INVALID_DATE }

        return input.toInt()
    }

    private fun isNotEmptyOrBlank(input: String) = !(input.isEmpty() || input.isBlank())

    private fun isDigitAll(input: String) = input.all { it.isDigit() }
}