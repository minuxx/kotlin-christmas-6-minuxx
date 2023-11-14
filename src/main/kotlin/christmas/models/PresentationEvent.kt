package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE

class PresentationEvent(private val date: Int) {
    private val menu: Menu = Menu(MenuItem.CHAMPAGNE, 1)

    init {
        require(isValidEventDate()) { INVALID_EVENT_DATE }
    }

    fun menu() = menu.toString()

    fun benefitAmount() = menu.amount()

    private fun isValidEventDate() = true

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
    }
}