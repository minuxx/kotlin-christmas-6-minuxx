package christmas.controllers

import christmas.models.EventDate
import christmas.views.InputView

class EventPlanner {
    private val inputView = InputView()

    fun start() {
        val visitDate = inputVisitDate()
    }

    private fun inputVisitDate(): EventDate {
        val value = inputView.readDate()
        return EventDate(value)
    }
}