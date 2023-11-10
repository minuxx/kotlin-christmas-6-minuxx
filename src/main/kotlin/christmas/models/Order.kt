package christmas.models

import christmas.constants.ErrorMessage.INVALID_ORDER
import christmas.constants.MenuType

class Order(private val menus: List<Menu>) {

    init {
        require(validateTotalOrderCount() && validateNonDrinkMenuTypes()) { INVALID_ORDER }
    }

    private fun validateTotalOrderCount() = menus.sumOf { it.count } <= MAX_TOTAL_ORDER_COUNT

    private fun validateNonDrinkMenuTypes() = !menus.all { it.item.type == MenuType.DRINK }

    companion object {
        const val MAX_TOTAL_ORDER_COUNT = 20
    }
}