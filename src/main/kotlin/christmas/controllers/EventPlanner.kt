package christmas.controllers

import christmas.models.EventDate
import christmas.views.InputView

class EventPlanner {
    private val inputView = InputView()

    fun start() {
//        val visitDate = inputVisitDate()
        inputOrder()

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

    private fun inputOrder() {
        val order = inputView.readOrder()
        println(order)
    }
}