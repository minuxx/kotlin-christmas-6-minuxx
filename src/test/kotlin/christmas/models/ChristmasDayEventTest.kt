package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ChristmasDayEventTest {
    @Test
    fun `이벤트날짜가 크리스마스 디데이 할인 기간이 아니면 예외가 발생한다`() {
        val eventDate = 26

        val exception = assertThrows<IllegalArgumentException> { ChristmasDayEvent(eventDate) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_EVENT_DATE)
    }

    @Test
    fun `이벤트날짜가 크리스마스 디데이 할인 기간이면 예외가 발생하지 않는다`() {
        val eventDate = 25

        assertDoesNotThrow { ChristmasDayEvent(eventDate) }
    }

    @Test
    fun `이벤트날짜에 해당하는 할인 금액을 계산한다`() {
        val christmasDayEvent = ChristmasDayEvent(1)
        val expectedDiscountAmount = 1000

        val actualBenefitAmount = christmasDayEvent.discountAmount()

        assertThat(actualBenefitAmount).isEqualTo(expectedDiscountAmount)
    }
}