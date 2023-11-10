package christmas.models

import christmas.constants.ErrorMessage.INVALID_ORDER

class Order(private val menus: List<Menu>) {

    init {
        require(validateTotalOrderCount()) { INVALID_ORDER }
    }

    private fun validateTotalOrderCount() = menus.sumOf { it.count } <= MAX_TOTAL_ORDER_COUNT

    companion object {
        const val MAX_TOTAL_ORDER_COUNT = 20
    }
}