package christmas.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EventGeneratorTest {

    @Test
    fun `총 주문 금액이 10,000원 미만이면 이벤트를 생성하지 않는다`() {
        val date = 1
        val order = Order(listOf(
            Menu(MenuItem.TAPAS, 1)
        ))

        val actualEvents = EventGenerator(date, order).execute()

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
    fun `크리스마스 디데이 할인 이벤트 기간에 방문하면 해당 이벤트를 생성한다`() {
        val date = 1
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()
        val hasChristmasDDayEvent = actualEvents.any { it is ChristmasDDayEvent }

        assertThat(hasChristmasDDayEvent).isTrue()
    }

    @Test
    fun `크리스마스 디데이 할인 이벤트 기간에 방문하지 않으면 해당 이벤트를 생성하지 않는다`() {
        val date = 26
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(date, order)

        val actualEvents = eventGenerator.execute()
        val hasChristmasDDayEvent = actualEvents.any { it is ChristmasDDayEvent }

        assertThat(hasChristmasDDayEvent).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [
        3, 4, 5, 6, 7,
        10, 11, 12, 13, 14,
        17, 18, 19, 20, 21,
        24, 25, 26, 27, 28,
        31
    ])
    fun `평일 할인 이벤트 기간에 방문하면 해당 이벤트를 생성한다`(expectedDate: Int) {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(expectedDate, order)

        val actualEvents = eventGenerator.execute()
        val hasWeekdayEvent = actualEvents.any { it is WeekdayEvent }

        assertThat(hasWeekdayEvent).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [
        1, 2, 8, 9, 15,
        16, 22, 23, 29, 30
    ])
    fun `평일 할인 이벤트 기간에 방문하지 않으면 해당 이벤트를 생성하지 않는다`(expectedDate: Int) {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(expectedDate, order)

        val actualEvents = eventGenerator.execute()
        val hasWeekdayEvent = actualEvents.any { it is WeekdayEvent }

        assertThat(hasWeekdayEvent).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [
        1, 2, 8, 9, 15,
        16, 22, 23, 29, 30
    ])
    fun `주말 할인 이벤트 기간에 방문하면 해당 이벤트를 생성한다`(expectedDate: Int) {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(expectedDate, order)

        val actualEvents = eventGenerator.execute()
        val hasWeekendEvent = actualEvents.any { it is WeekendEvent }

        assertThat(hasWeekendEvent).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [
        3, 4, 5, 6, 7,
        10, 11, 12, 13, 14,
        17, 18, 19, 20, 21,
        24, 25, 26, 27, 28,
        31
    ])
    fun `주말 할인 이벤트 기간에 방문하지 않으면 해당 이벤트를 생성하지 않는다`(expectedDate: Int) {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(expectedDate, order)

        val actualEvents = eventGenerator.execute()
        val hasWeekendEvent = actualEvents.any { it is WeekendEvent }

        assertThat(hasWeekendEvent).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 10, 17, 24, 25, 31])
    fun `특별 할인 이벤트 기간에 방문하면 해당 이벤트를 생성한다`(expectedDate: Int) {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(expectedDate, order)

        val actualEvents = eventGenerator.execute()
        val hasSpecialEvent = actualEvents.any { it is SpecialEvent }

        assertThat(hasSpecialEvent).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [
        2, 4, 5, 6, 7,
        8, 9, 11, 12, 13,
        14, 15, 16, 18, 19,
        20, 21, 22, 23, 26, 27,
        28, 29, 30
    ])
    fun `특별 할인 이벤트 기간에 방문하지 않으면 해당 이벤트를 생성하지 않는다`(expectedDate: Int) {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 1)
        ))
        val eventGenerator = EventGenerator(expectedDate, order)

        val actualEvents = eventGenerator.execute()
        val hasSpecialEvent = actualEvents.any { it is SpecialEvent }

        assertThat(hasSpecialEvent).isFalse()
    }


    @Test
    fun `총주문 금액이 120,000원 이상이면 증정 이벤트를 생성한다`() {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 3)
        ))
        val eventGenerator = EventGenerator(1, order)

        val actualEvents = eventGenerator.execute()
        val hasPresentationEvent = actualEvents.any { it is PresentationEvent }

        assertThat(hasPresentationEvent).isTrue()
    }

    @Test
    fun `총주문 금액이 120,000원 미만이면 증정 이벤트를 생성하지 않는다`() {
        val order = Order(listOf(
            Menu(MenuItem.BBQ_RIBS, 2)
        ))
        val eventGenerator = EventGenerator(1, order)

        val actualEvents = eventGenerator.execute()
        val hasPresentationEvent = actualEvents.any { it is PresentationEvent }

        assertThat(hasPresentationEvent).isFalse()
    }
}
