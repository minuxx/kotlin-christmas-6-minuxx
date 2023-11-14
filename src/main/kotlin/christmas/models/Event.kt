package christmas.models

abstract class Event(private val date: Int) {
    protected abstract val benefitAmount: Int

    abstract fun benefitAmount(): Int

    abstract override fun toString(): String

    fun isValidEventDate(): Boolean = date in START_DATE..END_DATE

    companion object {
        const val START_DATE = 1
        const val END_DATE = 31
    }
}