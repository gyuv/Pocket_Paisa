package com.rork.pocketpaisa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val id: String,
    val amount: Double,
    val merchant: String,
    val category: TransactionCategory,
    val type: TransactionType,
    val date: String,
    val time: String,
    val bank: String,
    val note: String? = null,
    val aiInsight: String? = null,
    val isSubscription: Boolean = false
)

enum class TransactionCategory {
    FOOD, SHOPPING, TRAVEL, BILLS, RENT, EMI, INVESTMENTS, HEALTHCARE, ENTERTAINMENT, TRANSPORT, EDUCATION, SALARY, OTHER
}

enum class TransactionType {
    DEBIT, CREDIT, UPI, WALLET, ATM
}

val categoryColors = mapOf(
    TransactionCategory.FOOD to 0xFFFF6B6B,
    TransactionCategory.SHOPPING to 0xFF4ECDC4,
    TransactionCategory.TRAVEL to 0xFF45B7D1,
    TransactionCategory.BILLS to 0xFFFFA07A,
    TransactionCategory.RENT to 0xFF96CEB4,
    TransactionCategory.EMI to 0xFFDDA0DD,
    TransactionCategory.INVESTMENTS to 0xFF98D8C8,
    TransactionCategory.HEALTHCARE to 0xFFF7DC6F,
    TransactionCategory.ENTERTAINMENT to 0xFFBB8FCE,
    TransactionCategory.TRANSPORT to 0xFF85C1E9,
    TransactionCategory.EDUCATION to 0xFFF8C471,
    TransactionCategory.SALARY to 0xFF52BE80,
    TransactionCategory.OTHER to 0xFFBDC3C7
)

val categoryIcons = mapOf(
    TransactionCategory.FOOD to "Restaurant",
    TransactionCategory.SHOPPING to "ShoppingCart",
    TransactionCategory.TRAVEL to "Flight",
    TransactionCategory.BILLS to "Receipt",
    TransactionCategory.RENT to "Home",
    TransactionCategory.EMI to "CreditCard",
    TransactionCategory.INVESTMENTS to "TrendingUp",
    TransactionCategory.HEALTHCARE to "LocalHospital",
    TransactionCategory.ENTERTAINMENT to "Movie",
    TransactionCategory.TRANSPORT to "DirectionsCar",
    TransactionCategory.EDUCATION to "School",
    TransactionCategory.SALARY to "AccountBalance",
    TransactionCategory.OTHER to "MoreHoriz"
)
