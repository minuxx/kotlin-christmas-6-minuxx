package christmas.models.menus

import christmas.constants.ErrorMessage
import christmas.models.menus.Menu
import christmas.models.menus.MenuItem
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class MenuTest {
    @Test
    fun `주문한 메뉴 항목 개수가 1개 미만이라면 예외가 발생한다`() {
        val orderCount = 0

        val exception = assertThrows<IllegalArgumentException> { Menu(MenuItem.BBQ_RIBS, orderCount) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @Test
    fun `주문한 메뉴 항목 개수가 1개 이상이라면 예외가 발생한다`() {
        val orderCount = 1

        assertDoesNotThrow { Menu(MenuItem.BBQ_RIBS, orderCount) }
    }

    @Test
    fun `주문 메뉴 금액을 계산한다`() {
        val menu = Menu(MenuItem.BBQ_RIBS, 2)
        val expectedAmount = 108000

        val actualAmount = menu.amount()

        assertThat(actualAmount).isEqualTo(expectedAmount)
    }
}