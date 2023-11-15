package christmas.models.events

import christmas.models.events.EventBadge
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class EventBadgeTest {

    @ParameterizedTest
    @CsvSource(
        "4_999, NOTHING",
        "5_000, STAR",
        "9_999, STAR",
        "10_000, TREE",
        "19_999, TREE",
        "20_000, SANTA",
        "100_000, SANTA"
    )
    fun `총혜택 금액에 해당하는 배지를 부여한다`(benefitAmount: Int, expectedEventBadge: EventBadge) {
        val actualEventBadge = EventBadge.of(benefitAmount)

        assertThat(actualEventBadge).isEqualTo(expectedEventBadge)
    }
}