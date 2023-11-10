package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MenuItemTest {

    @ParameterizedTest
    @ValueSource(strings = ["제로콜라"]
    )
    fun `찾고자 하는 메뉴가 없으면 예외가 발생한다`(description: String) {
        val exception = assertThrows<IllegalArgumentException> { MenuItem.of(description) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @ParameterizedTest
    @ValueSource( strings = [""])
    fun `찾고자 하는 메뉴가 있으면 예외가 발생하지 않는다`(description: String) {
        assertDoesNotThrow { MenuItem.of(description) }
    }
}