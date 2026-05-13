package com.rork.pocketpaisa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Insight(
    val id: String,
    val title: String,
    val description: String,
    val type: InsightType,
    val severity: InsightSeverity,
    val actionLabel: String? = null
)

enum class InsightType {
    SPENDING, SAVING, SUBSCRIPTION, BUDGET, INVESTMENT, FRAUD
}

enum class InsightSeverity {
    INFO, WARNING, CRITICAL, POSITIVE
}
