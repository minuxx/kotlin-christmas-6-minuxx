package christmas.controllers

import christmas.models.*
import christmas.views.InputView
import christmas.views.OutputView

class EventPlanner {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printWelcome()

        val visitDate = inputVisitDate()
        val order = inputOrder()

        outputView.printPreview(visitDate.value())
        outputView.printOrderMenu(order.toString())
        outputView.printOrderTotalAmount(order.amount())

        val eventGenerator = EventGenerator(visitDate.value(), order)
        val events = Events(eventGenerator.execute())

        outputView.printPresentationMenu(events.presentationMenu())
        outputView.printBenefitHistory(events.benefitHistories())

        val totalBenefitAmount = events.totalBenefitAmount()

        outputView.printTotalBenefitAmount(totalBenefitAmount)

        val discountedAmount = order.amount() - events.totalDiscountAmount()
        outputView.printDiscountedAmount(discountedAmount)

        val eventBadge = EventBadge.of(totalBenefitAmount)
        outputView.printEventBadge(eventBadge.description)
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