package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ChristmasDayEventTest {
    @Test
    fun `방문날짜가 크리스마스 디데이 할인 기간이 아니면 예외가 발생한다`() {
        val visitDate = 26

        val exception = assertThrows<IllegalArgumentException> { ChristmasDayEvent(visitDate) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_EVENT_DATE)
    }

    @Test
    fun `방문날짜가 크리스마스 디데이 할인 기간이면 예외가 발생하지 않는다`() {
        val visitDate = 25

        assertDoesNotThrow { ChristmasDayEvent(visitDate) }
    }
}