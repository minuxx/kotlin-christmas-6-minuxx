package christmas.models.menus

import christmas.constants.ErrorMessage
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class OrderTest {
    @Test
    fun `주문한 메뉴의 총 개수가 20개 초과이면 예외가 발생한다`() {
        val menus = listOf(
            Menu(MenuItem.BBQ_RIBS, 10),
            Menu(MenuItem.ZERO_COLA, 11)
        )

        val exception = assertThrows<IllegalArgumentException> { Order(menus) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @Test
    fun `주문한 메뉴의 총 개수가 20개 이하면 예외가 발생하지 않는다`() {
        val menus = listOf(
            Menu(MenuItem.BBQ_RIBS, 10),
            Menu(MenuItem.ZERO_COLA, 10)
        )

        assertDoesNotThrow { Order(menus) }
    }

    @Test
    fun `주문한 메뉴 항목들이 모두 음료인 경우이면 예외가 발생한다`() {
        val menus = listOf(
            Menu(MenuItem.ZERO_COLA, 2),
            Menu(MenuItem.RED_WINE, 1)
        )

        val exception = assertThrows<IllegalArgumentException> { Order(menus) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @Test
    fun `주문한 메뉴 항목들이 모두 음료인 경우가 아니라면 예외가 발생한다`() {
        val menus = listOf(
            Menu(MenuItem.BBQ_RIBS, 2),
            Menu(MenuItem.RED_WINE, 1)
        )

        assertDoesNotThrow { Order(menus) }
    }

    @Test
    fun `중복된 주문 메뉴가 있으면 예외가 발생한다`() {
        val menus = listOf(
            Menu(MenuItem.ICE_CREAM, 1),
            Menu(MenuItem.BBQ_RIBS, 2),
            Menu(MenuItem.ICE_CREAM, 2)
        )

        val exception = assertThrows<IllegalArgumentException> { Order(menus) }

        assertThat(exception.message).isEqualTo(ErrorMessage.INVALID_ORDER)
    }

    @Test
    fun `중복된 주문 메뉴가 없으면 예외가 발생하지 않는다`() {
        val menus = listOf(
            Menu(MenuItem.ICE_CREAM, 1),
            Menu(MenuItem.BBQ_RIBS, 2),
        )

        assertDoesNotThrow { Order(menus) }
    }

    @Test
    fun `주문 메뉴 리스트의 총금액을 계산한다`() {
        val order = Order(
            listOf(
                Menu(MenuItem.BUTTON_MUSHROOM_SOUP, 2),
                Menu(MenuItem.BBQ_RIBS, 2),
                Menu(MenuItem.RED_WINE, 1),
                Menu(MenuItem.CHOCOLATE_CAKE, 1),
            )
        )
        val expectedAmount = 12000 + 108000 + 60000 + 15000

        val actualAmount = order.amount()

        assertThat(actualAmount).isEqualTo(expectedAmount)
    }
}