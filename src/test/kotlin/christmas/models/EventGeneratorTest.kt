package christmas.models

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EventGeneratorTest {

    @Test
    fun `총 주문 금액이 10,000원 미만이면 이벤트를 생성하지 않는다`() {
        val date = 1
        val order = Order(listOf(
            Menu(MenuItem.TAPAS, 1)
        ))

        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()

        assertTrue(actualEvents.isEmpty())
    }

    @Test
    fun `총 주문 금액이 10,000원 이상이면 이벤트를 생성한다`() {
        val date = 1
        val order = Order(listOf(
            Menu(MenuItem.TAPAS, 2)
        ))

        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()

        assertFalse(actualEvents.isEmpty())
    }

    @Test
    fun `크리스마스 디데이 이벤트 기간에 방문하면 해당 이벤트를 생성한다`() {
        val date = 1
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()

        assertTrue(actualEvents.any { it is ChristmasDDayEvent })
    }

    @Test
    fun `크리스마스 디데이 이벤트 기간에 방문하지 않으면 해당 이벤트를 생성하지 않는다`() {
        val date = 26
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()

        assertFalse(actualEvents.any { it is ChristmasDDayEvent })
    }
}