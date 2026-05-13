package com.rork.pocketpaisa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatMessage(
    val id: String,
    val content: String,
    val isUser: Boolean,
    val timestamp: String,
    val hasAction: Boolean = false,
    val actionLabel: String? = null
)
