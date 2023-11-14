package christmas.views

import christmas.constants.Constants
import christmas.constants.Constants.CURRENCY_UNIT
import christmas.constants.Constants.EVENT_MONTH
import christmas.constants.Constants.HYPHEN
import christmas.constants.Constants.MINUS_CURRENCY_UNIT
import christmas.constants.Constants.NEW_LINE
import christmas.constants.Constants.ZERO
import christmas.constants.Extensions.withCommas

class OutputView {

    fun printWelcome() {
        println(WELCOME_MESSAGE)
    }

    fun printPreview(eventDate: Int) {
        println(PREVIEW_EVENT_BENEFIT_MESSAGE.format(eventDate) + NEW_LINE)
    }

    fun printOrderMenu(orderMenu: String) {
        println(ORDER_MENU_MESSAGE)
        println(orderMenu + NEW_LINE)
    }

    fun printOrderTotalAmount(amount: Int) {
        println(ORDER_TOTAL_AMOUNT_MESSAGE)
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

    fun printTotalBenefitAmount(totalBenefitAmount: Int) {
        println(TOTAL_BENEFIT_AMOUNT_MESSAGE)

        if (totalBenefitAmount != 0) {
            println(MINUS_CURRENCY_UNIT.format(totalBenefitAmount.withCommas()) + NEW_LINE)
        } else {
            println(CURRENCY_UNIT.format(ZERO) + NEW_LINE)
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

    companion object {
        private const val WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val PREVIEW_EVENT_BENEFIT_MESSAGE = "${EVENT_MONTH}월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        private const val ORDER_MENU_MESSAGE = "<주문 메뉴>"
        private const val ORDER_TOTAL_AMOUNT_MESSAGE = "<할인 전 총주문 금액>"

        private const val PRESENTATION_MENU_MESSAGE = "<증정 메뉴>"
        private const val BENEFIT_HISTORY_MESSAGE = "<혜택 내역>"
        private const val TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>"
        private const val DISCOUNTED_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>"
        private const val EVENT_BADGE_MESSAGE = "<${EVENT_MONTH}월 이벤트 배지>"
    }
}