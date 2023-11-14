package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WeekendEventTest {
    @ParameterizedTest
    @ValueSource(ints = [
        0, 32,
        3, 4, 5, 6, 7,
        10, 11, 12, 13, 14,
        17, 18, 19, 20, 21,
        24, 25, 26, 27, 28,
        31
    ]) // 범위, 평일(일 ~ 목)
    fun `주말 할인 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(date: Int) {
        val exception = assertThrows<IllegalArgumentException> { WeekendEvent(date, 0) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_EVENT_DATE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 8, 9, 15, 16, 22, 23, 29, 30])
    fun `주말 할인 이벤트 날짜가 유효하면 예외가 발생하지 않는다`(date: Int) {
        assertDoesNotThrow { WeekendEvent(date, 0) }
    }
}