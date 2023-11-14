package christmas.models

import christmas.constants.Constants.NEW_LINE
import christmas.constants.Constants.NOTHING

class Events(private val value: List<Event>) {

    fun presentationMenu(): String {
        val event = value.find { it is PresentationEvent } as PresentationEvent?

        return event?.menu() ?: NOTHING
    }

    fun benefitHistories(): String = value.joinToString(NEW_LINE) { it.toString() }
}