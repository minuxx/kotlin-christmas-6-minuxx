package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MenuItemTest {

    @Test
    fun `찾고자 하는 메뉴가 없으면 예외가 발생한다`() {
        val description = "없는 메뉴"

        val exception = assertThrows<IllegalArgumentException> { MenuItem.of(description) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @ParameterizedTest
    @ValueSource( strings = [
        "양송이수프", "티파스", "시저샐러드",
        "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
        "초코케이크", "아이스크림",
        "제로콜라", "레드와인", "샴페인"
    ])
    fun `찾고자 하는 메뉴가 있으면 예외가 발생하지 않는다`(description: String) {
        assertDoesNotThrow { MenuItem.of(description) }
    }
}