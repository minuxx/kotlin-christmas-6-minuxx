package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PresentationEventTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 32]) // 범위
    fun `증정 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(date: Int) {
        val exception = assertThrows<IllegalArgumentException> { PresentationEvent(date) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_EVENT_DATE)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 11, 20, 27])
    fun `증정 할인 이벤트 날짜가 유효하면 예외가 발생하지 않는다`(date: Int) {
        assertDoesNotThrow { PresentationEvent(date) }
    }
}