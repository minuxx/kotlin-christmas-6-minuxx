package christmas.views

import camp.nextstep.edu.missionutils.Console
import christmas.constants.ErrorMessage

class InputView {
    private val inputValidator = InputValidator()

    fun readDate(): Int {
        println(INPUT_VISIT_DATE_MESSAGE)
        val input = Console.readLine()

        return inputValidator.validateDateInput(input)
    }

    fun printInputErrorMessage(message: String?) = println("${message ?: ErrorMessage.UNKNOWN}${INPUT_AGAIN}")

    companion object {
        private const val INPUT_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        private const val INPUT_AGAIN = "다시 입력해주세요."
    }
}