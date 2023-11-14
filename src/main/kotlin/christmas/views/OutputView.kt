package christmas.views

import christmas.constants.Constant.NEW_LINE

class OutputView {

    fun printWelcome() = println(WELCOME_MESSAGE)

    fun printPreview() = println(PREVIEW_MESSAGE + NEW_LINE)

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

    companion object {
        private const val WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        private const val ORDER_MENU_MESSAGE = "<주문 메뉴>"
        private const val ORDER_TOTAL_AMOUNT_MESSAGE = "<할인 전 총주문 금액>"
        private const val CURRENCY_UNIT = "%s원"

        private const val PRESENTATION_MENU_MESSAGE = "<증정 메뉴>"
    }
}

fun Int.withCommas(): String {
    return "%,d".format(this)
}