package christmas.models.events

import christmas.constants.Constants.NEW_LINE
import christmas.constants.Constants.NOTHING

class Events(private val value: List<Event>) {

    fun presentationMenu(): String {
        val presentationEvent = value.filterIsInstance<PresentationEvent>().firstOrNull()
        return presentationEvent?.menu() ?: NOTHING
    }

    fun benefitHistory(): String {
        return if (value.isEmpty()) NOTHING
        else value.joinToString(NEW_LINE) { it.toString() }
    }

    fun benefitAmount(): Int = value.sumOf { it.benefitAmount() }

    fun discountAmount(): Int {
        val discountEvents = value.filter { it !is PresentationEvent }
        return discountEvents.sumOf { it.benefitAmount() }
    }
}