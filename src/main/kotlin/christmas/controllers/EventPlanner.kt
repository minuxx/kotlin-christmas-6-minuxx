package christmas.controllers

import christmas.models.EventDate
import christmas.models.Menu
import christmas.models.MenuItem
import christmas.models.Order
import christmas.views.InputView

class EventPlanner {
    private val inputView = InputView()

    fun start() {
        val visitDate = inputVisitDate()
        val order = inputOrder()
        println(order.menus())
    }

    private fun inputVisitDate(): EventDate {
        return try {
            val value = inputView.readDate()

            return EventDate(value)
        } catch (e: IllegalArgumentException) {
            inputView.printInputErrorMessage(e.message)
            inputVisitDate()
        }
    }

    private fun inputOrder(): Order {
        return try {
            val order = inputView.readOrder()
            val menus = createMenus(order)

            return Order(menus)
        } catch (e: IllegalArgumentException) {
            inputView.printInputErrorMessage(e.message)
            inputOrder()
        }
    }

    private fun createMenus(order: List<Pair<String, Int>>): List<Menu> {
        val menus = mutableListOf<Menu>()

        order.forEach { (description, count) ->
            val item = MenuItem.of(description)
            val menu = Menu(item, count)
            menus.add(menu)
        }

        return menus
    }
}