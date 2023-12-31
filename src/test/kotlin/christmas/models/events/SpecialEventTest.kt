package christmas.models.events

import christmas.constants.ErrorMessage
import christmas.models.events.SpecialEvent
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SpecialEventTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 32, 11, 19, 26, 29])
    fun `특별 할인 이벤트 날짜가 유효하지 않으면 예외가 발생한다`(date: Int) {
        val exception = assertThrows<IllegalArgumentException> { SpecialEvent(date) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_DATE)
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 10, 17, 24, 25, 31])
    fun `특별 할인 이벤트 날짜가 유효하면 예외가 발생하지 않는다`(date: Int) {
        assertDoesNotThrow { SpecialEvent(date) }
    }
}