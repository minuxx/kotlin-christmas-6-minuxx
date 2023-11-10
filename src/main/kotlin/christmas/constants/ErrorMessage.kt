package christmas.constants

object ErrorMessage {
    private const val ERROR_PREFIX = "[ERROR]"

    const val UNKNOWN = "알 수 없는 에러가 발생했습니다."
    const val INVALID_DATE = "$ERROR_PREFIX 유효하지 않은 날짜입니다."
    const val INVALID_ORDER = "$ERROR_PREFIX 유효하지 않은 주문입니다."
}