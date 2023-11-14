package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WeekdayEventTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 16, 24]) // 범위, 토요일, 일요일
    fun `평일 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(eventDate: Int) {
        val exception = assertThrows<IllegalArgumentException> { WeekdayEvent(eventDate) }

        assertThat(exception.message).isEqualTo(INVALID_EVENT_DATE)
    }
}