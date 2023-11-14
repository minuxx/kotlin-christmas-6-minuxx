package christmas.models

import christmas.constants.Constants.NOTHING
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class EventsTest {

    @Test
    fun `증정 이벤트에 해당할 때 증정 메뉴를 알려준다`() {
        val event = PresentationEvent(1, 125_000)
        val events = Events(listOf(event))
        val expectedPresentationMenu = Menu(MenuItem.CHAMPAGNE, 1).toString()

        val actualPresentationMenu = events.presentationMenu()

        assertThat(actualPresentationMenu).isEqualTo(expectedPresentationMenu)
    }

    @Test
    fun `증정 이벤트에 해당하지 않으면 없음이라고 알려준다`() {
        val event = WeekendEvent(1, 1)
        val events = Events(listOf(event))
        val expectedPresentationMenu = NOTHING

        val actualPresentationMenu = events.presentationMenu()

        assertThat(actualPresentationMenu).isEqualTo(expectedPresentationMenu)
    }
}