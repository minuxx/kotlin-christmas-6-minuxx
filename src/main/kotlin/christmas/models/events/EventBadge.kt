package christmas.models.events

enum class EventBadge(val description: String, val minimumBenefitAmount: Int) {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    NOTHING("없음", 0);

    companion object {
        fun of(benefitAmount: Int): EventBadge {
            return when {
                benefitAmount >= SANTA.minimumBenefitAmount -> SANTA
                benefitAmount >= TREE.minimumBenefitAmount -> TREE
                benefitAmount >= STAR.minimumBenefitAmount -> STAR
                else -> NOTHING
            }
        }
    }
}