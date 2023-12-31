package christmas.models.events

import christmas.constants.ErrorMessage
import christmas.models.events.EventDate
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EventDateTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 32])
    fun `유효하지 않은 날짜 범위에 대해 예외가 발생한다`(value: Int) {
        val exception = assertThrows<IllegalArgumentException> { EventDate(value) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_DATE)
    }

    @Test
    fun `유효한 날짜 범위에 대해 예외가 발생하지 않는다`() {
        val value = 10

        assertDoesNotThrow { EventDate(value) }
    }
}