package christmas.models

class EventGenerator(private val date: Int, private val order: Order) {

    fun execute(): List<Event> {
        val events = mutableListOf<Event>()
        val orderAmount = order.amount()

        if (MINIMUM_ORDER_AMOUNT > orderAmount) {
            return emptyList()
        }

        create { ChristmasDDayEvent(date) }?.let { events.add(it)  }
        create { WeekdayEvent(date, order.dessertMenuCount()) }?.let { events.add(it)  }
        create { WeekendEvent(date, order.mainMenuCount()) }?.let { events.add(it)  }
        create { SpecialEvent(date) }?.let { events.add(it)  }
        create { PresentationEvent(date, orderAmount) }?.let { events.add(it)  }

        return events.toList()
    }

    private fun create(event: () -> Event?): Event? {
        return try {
            event()
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    companion object {
        private const val MINIMUM_ORDER_AMOUNT = 10_000
    }
}