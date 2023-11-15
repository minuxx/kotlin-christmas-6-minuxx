package christmas.models.menus

import christmas.constants.Constants.NEW_LINE
import christmas.constants.ErrorMessage.INVALID_ORDER
import christmas.models.menus.MenuType.MAIN
import christmas.models.menus.MenuType.DRINK
import christmas.models.menus.MenuType.DESSERT

class Order(private val menus: List<Menu>) {

    init {
        require(
            isValidMenuCount()
                    && isNonDrinkMenuTypes()
                    && isUniqueMenuItems()
        ) { INVALID_ORDER }
    }

    fun amount() = menus.sumOf { it.amount() }

    fun mainMenuCount() = menus.filter { it.item.type == MAIN }.sumOf { it.count }

    fun dessertMenuCount() = menus.filter { it.item.type == DESSERT }.sumOf { it.count }

    override fun toString() = menus.joinToString(NEW_LINE) { it.toString() }

    private fun isValidMenuCount() = menus.sumOf { it.count } <= MAXIMUM_MENU_COUNT

    private fun isNonDrinkMenuTypes() = !menus.all { it.item.type == DRINK }

    private fun isUniqueMenuItems() = menus.distinctBy { it.item }.size == menus.size

    companion object {
        const val MAXIMUM_MENU_COUNT = 20
    }
}