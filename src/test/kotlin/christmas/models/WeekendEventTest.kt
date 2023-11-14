package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WeekendEventTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 32, 1, 11, 20, 27]) // 범위, 평일
    fun `주말 할인 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(eventDate: Int) {
        val exception = assertThrows<IllegalArgumentException> { WeekendEvent(eventDate) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_EVENT_DATE)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 9, 10, 16, 17, 23, 24, 30, 31, 27])
    fun `주말 할인 이벤트 날짜가 유효하면 예외가 발생하지 않는다`(eventDate: Int) {
        assertDoesNotThrow { WeekendEvent(eventDate) }
    }
}