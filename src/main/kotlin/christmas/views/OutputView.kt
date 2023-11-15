package christmas.views

import christmas.constants.Constants.CURRENCY_UNIT
import christmas.constants.Constants.MINUS_CURRENCY_UNIT
import christmas.constants.Constants.NEW_LINE
import christmas.constants.ErrorMessage
import christmas.constants.Extensions.withCommas
import christmas.models.events.Event

class OutputView {

    fun printWelcome() = println(WELCOME_MESSAGE)

    fun printPreviewEvent(eventDate: Int) = println(PREVIEW_EVENT_MESSAGE.format(eventDate) + NEW_LINE)

    fun printOrderMenu(orderMenu: String) {
        println(ORDER_MENU_MESSAGE)
        println(orderMenu + NEW_LINE)
    }

    fun printOrderAmount(amount: Int) {
        println(ORDER_AMOUNT_MESSAGE)
        println(CURRENCY_UNIT.format(amount.withCommas()) + NEW_LINE)
    }

    fun printPresentationMenu(presentationMenu: String) {
        println(PRESENTATION_MENU_MESSAGE)
        println(presentationMenu + NEW_LINE)
    }

    fun printBenefitHistory(benefitHistory: String) {
        println(BENEFIT_HISTORY_MESSAGE)
        println(benefitHistory + NEW_LINE)
    }

    fun printBenefitAmount(benefitAmount: Int) {
        println(BENEFIT_AMOUNT_MESSAGE)

        if (benefitAmount != 0) {
            println(MINUS_CURRENCY_UNIT.format(benefitAmount.withCommas()) + NEW_LINE)
        } else {
            println(CURRENCY_UNIT.format(benefitAmount) + NEW_LINE)
        }
    }

    fun printDiscountedAmount(discountedAmount: Int) {
        println(DISCOUNTED_AMOUNT_MESSAGE)
        println(CURRENCY_UNIT.format(discountedAmount.withCommas()) + NEW_LINE)
    }

    fun printEventBadge(eventBadge: String) {
        println(EVENT_BADGE_MESSAGE)
        println(eventBadge + NEW_LINE)
    }

    fun printInputVisitDate() = println(INPUT_VISIT_DATE_MESSAGE)

    fun printInputOrder() = println(INPUT_ORDER_MESSAGE)

    fun printInputErrorMessage(message: String?) = println("${message ?: ErrorMessage.UNKNOWN} $INPUT_AGAIN_MESSAGE")

    companion object {
        private const val WELCOME_MESSAGE = "안녕하세요! 우테코 식당 ${Event.MONTH}월 이벤트 플래너입니다."
        private const val PREVIEW_EVENT_MESSAGE = "${Event.MONTH}월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        private const val INPUT_VISIT_DATE_MESSAGE = "${Event.MONTH}월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        private const val INPUT_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
        private const val INPUT_AGAIN_MESSAGE = "다시 입력해 주세요."

        private const val ORDER_MENU_MESSAGE = "<주문 메뉴>"
        private const val ORDER_AMOUNT_MESSAGE = "<할인 전 총주문 금액>"
        private const val PRESENTATION_MENU_MESSAGE = "<증정 메뉴>"
        private const val BENEFIT_HISTORY_MESSAGE = "<혜택 내역>"
        private const val BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>"
        private const val DISCOUNTED_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>"
        private const val EVENT_BADGE_MESSAGE = "<${Event.MONTH}월 이벤트 배지>"
    }
}