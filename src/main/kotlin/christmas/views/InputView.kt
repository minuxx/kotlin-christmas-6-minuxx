package christmas.views

import camp.nextstep.edu.missionutils.Console
import christmas.constants.ErrorMessage

class InputView {
    private val inputValidator = InputValidator()

    fun readDate(): Int {
        val input = Console.readLine()

        return inputValidator.validateDateInput(input)
    }

    fun readOrder(): List<Pair<String, Int>> {
        val input = Console.readLine()

        return inputValidator.validateOrderInput(input)
    }
}