package christmas.models.events

import java.time.DateTimeException
import java.time.LocalDate

abstract class Event {
    protected abstract val benefitAmount: Int

    abstract fun benefitAmount(): Int

    abstract override fun toString(): String

    companion object {
        const val MONTH = 12
        const val START_DATE = 1
        const val END_DATE = 31

        fun isValidEventDate(date: Int): Boolean {
            return try {
                val eventDateTime = LocalDate.of(LocalDate.now().year, MONTH, date)
                eventDateTime.dayOfMonth in START_DATE..END_DATE
            } catch (e: DateTimeException) {
                false
            }
        }
    }
}