package christmas.controllers

import christmas.models.events.EventBadge
import christmas.models.events.EventDate
import christmas.models.events.EventGenerator
import christmas.models.events.Events
import christmas.models.menus.Menu
import christmas.models.menus.MenuItem
import christmas.models.menus.Order
import christmas.views.InputView
import christmas.views.OutputView

class EventPlanner {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        outputView.printWelcome()

        val visitDate = inputVisitDate()
        val order = inputOrder()

        printReceipt(visitDate, order)
        processEvents(visitDate, order)

        inputView.closeInput()
    }

    private fun printReceipt(visitDate: EventDate, order: Order) {
        outputView.printPreviewEvent(visitDate.value())
        outputView.printOrderMenu(order.toString())
        outputView.printOrderAmount(order.amount())
    }

    private fun processEvents(visitDate: EventDate, order: Order) {
        val eventGenerator = EventGenerator(visitDate.value(), order)
        val events = Events(eventGenerator.execute())

        outputView.printPresentationMenu(events.presentationMenu())
        outputView.printBenefitHistory(events.benefitHistory())

        val benefitAmount = events.benefitAmount()
        outputView.printBenefitAmount(benefitAmount)

        val discountedAmount = order.amount() - events.discountAmount()
        outputView.printDiscountedAmount(discountedAmount)

        val eventBadge = EventBadge.of(benefitAmount)
        outputView.printEventBadge(eventBadge.description)
    }

    private fun inputVisitDate(): EventDate {
        outputView.printInputVisitDate()

        return try {
            val value = inputView.readDate()

            return EventDate(value)
        } catch (e: IllegalArgumentException) {
            outputView.printInputErrorMessage(e.message)
            inputVisitDate()
        }
    }

    private fun inputOrder(): Order {
        outputView.printInputOrder()

        return try {
            val order = inputView.readOrder()
            val menus = createMenus(order)

            return Order(menus)
        } catch (e: IllegalArgumentException) {
            outputView.printInputErrorMessage(e.message)
            inputOrder()
        }
    }

    private fun createMenus(order: List<Pair<String, Int>>): List<Menu> {
        return order.map { (description, count) ->
            val item = MenuItem.of(description)
            Menu(item, count)
        }
    }
}