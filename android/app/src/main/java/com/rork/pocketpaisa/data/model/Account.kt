package com.rork.pocketpaisa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String,
    val name: String,
    val bankName: String,
    val accountNumber: String,
    val balance: Double,
    val type: AccountType,
    val cardNumber: String? = null,
    val cardExpiry: String? = null,
    val color: Long = 0xFF1E3A5F
)

enum class AccountType {
    BANK, CREDIT_CARD, WALLET, UPI
}
