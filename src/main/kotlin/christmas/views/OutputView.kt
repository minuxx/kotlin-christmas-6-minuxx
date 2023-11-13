package christmas.views

import christmas.constants.Constant.NEW_LINE

class OutputView {

    fun printWelcome() = println(WELCOME_MESSAGE)

    fun printPreview() = println(PREVIEW_MESSAGE + NEW_LINE)

    fun printOrderMenu(orderMenu: String) {
        println(ORDER_MENU_MESSAGE)
        println(orderMenu)
    }

    companion object {
        private const val WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        private const val ORDER_MENU_MESSAGE = "<주문 메뉴>"
    }
}