package christmas.models

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class OrderMenuTest {
    @Test
    fun `주문한 메뉴 항목 개수가 1개 미만이라면 예외가 발생한다`() {
        val orderCount = 0

        val exception = assertThrows<IllegalArgumentException> { OrderMenu(MenuItem.BBQ_RIBS, orderCount) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @Test
    fun `주문한 메뉴 항목 개수가 1개 이상이라면 예외가 발생한다`() {
        val orderCount = 1

        assertDoesNotThrow { OrderMenu(MenuItem.BBQ_RIBS, orderCount) }
    }
}