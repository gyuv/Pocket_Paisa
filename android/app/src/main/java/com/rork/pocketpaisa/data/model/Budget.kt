package com.rork.pocketpaisa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Budget(
    val id: String,
    val category: TransactionCategory,
    val limit: Double,
    val spent: Double,
    val month: String,
    val year: Int
)

@Serializable
data class SavingsGoal(
    val id: String,
    val name: String,
    val targetAmount: Double,
    val currentAmount: Double,
    val deadline: String,
    val icon: String = "Savings"
)
