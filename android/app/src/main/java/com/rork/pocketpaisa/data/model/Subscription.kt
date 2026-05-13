package com.rork.pocketpaisa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Subscription(
    val id: String,
    val name: String,
    val amount: Double,
    val billingCycle: BillingCycle,
    val nextBillingDate: String,
    val category: String,
    val logoUrl: String? = null,
    val isActive: Boolean = true
)

enum class BillingCycle {
    WEEKLY, MONTHLY, QUARTERLY, YEARLY
}
