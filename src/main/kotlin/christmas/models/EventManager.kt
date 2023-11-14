package christmas.models

class EventManager(private val date: Int, private val order: Order) {

    private fun createEvents() {
        try {
            val christmasDDayEvent = ChristmasDDayEvent(date)
        } catch (e: IllegalArgumentException) {

        }

        try {
            val weekendEvent = WeekendEvent(date, order.mainMenuCount())
        } catch (e: IllegalArgumentException) {

        }

        try {
            val weekdayEvent = WeekdayEvent(date, order.dessertMenuCount())
        } catch (e: IllegalArgumentException) {

        }

        try {
            val specialEvent = SpecialEvent(date)
        } catch (e: IllegalArgumentException) {

        }
    }
}