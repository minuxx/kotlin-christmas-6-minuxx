package christmas.models

import christmas.constants.Constant.NEW_LINE
import christmas.constants.ErrorMessage.INVALID_ORDER
import christmas.constants.MenuType.MAIN
import christmas.constants.MenuType.DRINK
import christmas.constants.MenuType.DESSERT

class Order(private val menus: List<Menu>) {

    init {
        require(validateOrder()) { INVALID_ORDER }
    }

    fun menus() = menus.toList()

    fun amount() = menus.sumOf { it.amount() }

    fun mainMenuCount() = menus.count { it.item.type == MAIN }

    fun dessertMenuCount() = menus.count { it.item.type == DESSERT }

    override fun toString() = menus.joinToString(NEW_LINE) { it.toString() }

    private fun validateOrder() = validateTotalOrderCount()
            && validateNonDrinkMenuTypes()
            && validateNoDuplicateMenuItems()

    private fun validateTotalOrderCount() = menus.sumOf { it.count } <= MAX_TOTAL_ORDER_COUNT

    private fun validateNonDrinkMenuTypes() = !menus.all { it.item.type == DRINK }

    private fun validateNoDuplicateMenuItems() = menus.distinctBy { it.item }.size == menus.size

    companion object {
        const val MAX_TOTAL_ORDER_COUNT = 20
    }
}