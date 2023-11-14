package christmas.models

import christmas.constants.Constants.ORDER_MENU
import christmas.constants.ErrorMessage.INVALID_ORDER

data class Menu(
    val item: MenuItem,
    val count: Int
) {
    init {
        require(validateOrderMenu()) { INVALID_ORDER }
    }

    fun amount() = item.price * count

    override fun toString() = ORDER_MENU.format(item.description, count)

    private fun validateOrderMenu() = count >= MIN_COUNT

    companion object {
        const val MIN_COUNT = 1
    }
}