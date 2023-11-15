package christmas.models.events

import christmas.models.menus.Order

class EventGenerator(private val date: Int, private val order: Order) {

    fun execute(): List<Event> {
        val events = mutableListOf<Event>()
        val orderAmount = order.amount()

        if (orderAmount < MINIMUM_ORDER_AMOUNT) {
            return emptyList()
        }

        create { ChristmasDDayEvent(date) }?.let { events.add(it)  }
        create { WeekdayEvent(date, order.dessertMenuCount()) }?.let { events.add(it)  }
        create { WeekendEvent(date, order.mainMenuCount()) }?.let { events.add(it)  }
        create { SpecialEvent(date) }?.let { events.add(it)  }
        create { PresentationEvent(date, orderAmount) }?.let { events.add(it)  }

        return events.toList()
    }

    private inline fun <reified T : Event> create(event: () -> T): T? {
        return runCatching { event() }.getOrNull()
    }

    companion object {
        private const val MINIMUM_ORDER_AMOUNT = 10_000
    }
}