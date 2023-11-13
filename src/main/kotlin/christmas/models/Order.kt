package christmas.models

import christmas.constants.Constant.NEW_LINE
import christmas.constants.ErrorMessage.INVALID_ORDER
import christmas.constants.MenuType

class Order(private val menus: List<Menu>) {

    init {
        require(validateOrder()) { INVALID_ORDER }
    }

    fun menus() = menus.toList()

    fun amount() = menus.sumOf { it.amount() }

    override fun toString() = menus.map { it.toString() }.joinToString(NEW_LINE)

    private fun validateOrder() = validateTotalOrderCount()
            && validateNonDrinkMenuTypes()
            && validateNoDuplicateMenuItems()

    private fun validateTotalOrderCount() = menus.sumOf { it.count } <= MAX_TOTAL_ORDER_COUNT

    private fun validateNonDrinkMenuTypes() = !menus.all { it.item.type == MenuType.DRINK }

    private fun validateNoDuplicateMenuItems() = menus.distinctBy { it.item }.size == menus.size

    companion object {
        const val MAX_TOTAL_ORDER_COUNT = 20
    }
}