package christmas.models

import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WeekdayEventTest {

    @Test
    fun `이벤트날짜가 평일 할인 기간이 아니면 예외가 발생한다`() {
        val eventDate = 16 // 2023.12.16

        val exception = assertThrows<IllegalArgumentException> { WeekdayEvent(eventDate) }

        assertThat(exception.message).isEqualTo(INVALID_EVENT_DATE)
    }
}