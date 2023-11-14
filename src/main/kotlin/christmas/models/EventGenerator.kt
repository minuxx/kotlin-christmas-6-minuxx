package christmas.models

class EventGenerator(private val date: Int, private val order: Order) {
    fun execute(): List<Event> {
        val events = mutableListOf<Event>()

        return events.toList()
    }

    private fun create(event: () -> Event?): Event? {
        return try {
            event()
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}