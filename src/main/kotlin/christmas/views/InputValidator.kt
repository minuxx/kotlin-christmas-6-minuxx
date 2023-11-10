package christmas.views

import christmas.constants.Constant.COMMA
import christmas.constants.Constant.HYPHEN
import christmas.constants.ErrorMessage.INVALID_DATE
import christmas.constants.ErrorMessage.INVALID_ORDER

class InputValidator {
    fun validateDateInput(input: String): Int {
        val trimmedInput = input.trim()

        val isValid = isNotEmptyOrBlank(trimmedInput) && isDigitAll(trimmedInput)
        require(isValid) { INVALID_DATE }

        return input.toInt()
    }

    fun validateOrderInput(input: String): List<Pair<String, Int>> {
        val orderPattern = Regex("""\s*(\p{L}[ \p{L}\s]*-\s*\d+)\s*(?:,\s*(\p{L}[ \p{L}\s]*-\s*\d+)\s*)*""")
        require(input.matches(orderPattern)) { INVALID_ORDER }

        return input.split(COMMA).map { parseMenuItem(it) }
    }

    private fun parseMenuItem(input: String): Pair<String, Int> {
        val (description, count) = input.split(HYPHEN).map { it.trim() }
        return description to count.toInt()
    }

    private fun isDigitAll(input: String) = input.all { it.isDigit() }

    private fun isNotEmptyOrBlank(input: String) = input.isNotEmpty() || input.isNotBlank()
}