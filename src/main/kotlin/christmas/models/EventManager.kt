package christmas.models

class EventManager(private val date: Int, private val order: Order) {
    private val events = mutableListOf<Event>()

}