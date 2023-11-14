package christmas.models

import christmas.constants.Constant.NOTHING

class Events(private val value: List<Event>) {

    fun presentationMenu(): String {
        val event = value.find { it is PresentationEvent } as PresentationEvent?

        return event?.menu() ?: NOTHING
    }
}