package christmas.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.AssertionsForClassTypes.assertThat

class EventGeneratorTest {
    @Test
    fun `크리스마스 디데이 이벤트 기간에 방문하면 이벤트가 생긴다`() {
        val date = 1
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()

        assertTrue(actualEvents.any { it is ChristmasDDayEvent })
    }
}