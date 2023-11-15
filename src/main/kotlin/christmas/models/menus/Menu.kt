package christmas.models.menus

import christmas.constants.Constants.MENU_WITH_COUNT
import christmas.constants.ErrorMessage.INVALID_ORDER

data class Menu(
    val item: MenuItem,
    val count: Int
) {
    init {
        require(isValidMenuCount()) { INVALID_ORDER }
    }

    fun amount() = item.price * count

    override fun toString() = MENU_WITH_COUNT.format(item.description, count)

    private fun isValidMenuCount() = count >= MINIMUM_COUNT

    companion object {
        const val MINIMUM_COUNT = 1
    }
}