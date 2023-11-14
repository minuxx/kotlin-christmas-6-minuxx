package christmas.constants

object Extensions {
    fun Int.withCommas(): String {
        return "%,d".format(this)
    }
}