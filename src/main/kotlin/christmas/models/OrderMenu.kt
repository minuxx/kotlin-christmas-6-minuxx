package christmas.models

import christmas.constants.ErrorMessage.INVALID_ORDER

data class OrderMenu(
    val item: MenuItem,
    val count: Int
) {
    init {
        require(validateOrderMenu()) { INVALID_ORDER }
    }

    fun validateOrderMenu() = false

    companion object {
        const val MIN_COUNT = 1
    }
}