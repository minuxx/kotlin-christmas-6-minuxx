package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WeekdayEventTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 32, 16, 24]) // 범위, 토요일, 일요일
    fun `평일 할인 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(date: Int) {
        val exception = assertThrows<IllegalArgumentException> { WeekdayEvent(date) }

        assertThat(exception.message).isEqualTo(INVALID_EVENT_DATE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 11, 20, 27])
    fun `평일 할인 이벤트 날짜가 유효하면 예외가 발생하지 않는다`(date: Int) {
        assertDoesNotThrow { WeekdayEvent(date) }
    }
}