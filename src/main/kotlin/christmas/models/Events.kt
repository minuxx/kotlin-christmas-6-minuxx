package christmas.models

import christmas.constants.Constants.NEW_LINE
import christmas.constants.Constants.NOTHING
import christmas.constants.Constants.ZERO

class Events(private val value: List<Event>) {

    fun presentationMenu(): String {
        val event = value.find { it is PresentationEvent } as PresentationEvent?

        return event?.menu() ?: NOTHING
    }

    fun benefitHistories(): String {
        return if (value.isEmpty()) NOTHING
        else value.joinToString(NEW_LINE) { it.toString() }
    }

    fun totalBenefitAmount(): Int {
        return if (value.isEmpty()) ZERO
        else value.sumOf { it.benefitAmount() }
    }

    fun totalDiscountAmount(): Int {
        return if (value.isEmpty()) ZERO
        else value.filter { it !is PresentationEvent }.sumOf { it.benefitAmount() }
    }
}