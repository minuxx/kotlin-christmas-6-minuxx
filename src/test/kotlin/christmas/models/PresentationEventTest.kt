package christmas.models

import christmas.constants.ErrorMessage
import christmas.constants.ErrorMessage.INVALID_EVENT_DATE
import christmas.constants.ErrorMessage.INVALID_MINIMUM_ORDER_AMOUNT_FOR_PRESENTATION_EVENT
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PresentationEventTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 32]) // 범위
    fun `증정 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(date: Int) {
        val exception = assertThrows<IllegalArgumentException> { PresentationEvent(date, 120_000) }

        assertThat(exception.message).isEqualTo(INVALID_EVENT_DATE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 11, 20, 27])
    fun `증정 할인 이벤트 날짜가 유효하면 예외가 발생하지 않는다`(date: Int) {
        assertDoesNotThrow { PresentationEvent(date, 120_000) }
    }

    @Test
    fun `총주문 금액이 유효하지 않으면 예외가 발생한다`() {
        val orderAmount = 119_999

        val exception = assertThrows<IllegalArgumentException> { PresentationEvent(1, orderAmount) }

        assertThat(exception.message).isEqualTo(INVALID_MINIMUM_ORDER_AMOUNT_FOR_PRESENTATION_EVENT)
    }

    @Test
    fun `총주문 금액이 유효하면 예외가 발생하지 않는다`() {
        val orderAmount = 120_000

        assertDoesNotThrow { PresentationEvent(1, orderAmount) }
    }
}