package com.rork.pocketpaisa.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.AutoFixHigh
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rork.pocketpaisa.ui.components.PremiumButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = { 5 })
    val scope = rememberCoroutineScope()

    val pages = listOf(
        OnboardingPage(
            "AI Financial Automation",
            "Let AI automatically track, categorize, and analyze every transaction from your SMS and notifications. No manual entry needed.",
            Icons.Default.AutoFixHigh,
            listOf(Color(0xFF00D4FF), Color(0xFF0066CC))
        ),
        OnboardingPage(
            "Smart SMS Parsing",
            "Our AI reads your banking SMS, UPI alerts, and credit card notifications to build a complete financial picture.",
            Icons.Default.Message,
            listOf(Color(0xFF39FF14), Color(0xFF00AA66))
        ),
        OnboardingPage(
            "Intelligent Analytics",
            "Get deep insights into your spending patterns, subscription tracking, and personalized saving recommendations.",
            Icons.Default.Analytics,
            listOf(Color(0xFFFF6B6B), Color(0xFFFF4757))
        ),
        OnboardingPage(
            "Privacy First",
            "Your financial data is encrypted and stored locally on your device. We never upload or share your data.",
            Icons.Default.Shield,
            listOf(Color(0xFF8B5CF6), Color(0xFF6B4EE6))
        ),
        OnboardingPage(
            "AI Finance Assistant",
            "Ask anything about your money. Get instant answers, predictions, and actionable financial advice.",
            Icons.Default.Chat,
            listOf(Color(0xFFFFD700), Color(0xFFFFA500))
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0A0F))
            .padding(24.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPageContent(pages[page])
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            pages.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(if (index == pagerState.currentPage) 10.dp else 8.dp)
                        .background(
                            if (index == pagerState.currentPage) Color(0xFF00D4FF) else Color.White.copy(alpha = 0.3f),
                            CircleShape
                        )
                )
                if (index < pages.size - 1) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (pagerState.currentPage < pages.size - 1) {
            PremiumButton(
                text = "Next",
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                gradientColors = listOf(Color(0xFF00D4FF), Color(0xFF39FF14))
            )
        } else {
            PremiumButton(
                text = "Get Started",
                onClick = {
                    navController.navigate("home") {
                        popUpTo("onboarding") { inclusive = true }
                    }
                },
                gradientColors = listOf(Color(0xFF00D4FF), Color(0xFF39FF14))
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
private fun OnboardingPageContent(page: OnboardingPage) {
    val scale = remember { Animatable(0.8f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(page) {
        scale.animateTo(1f, animationSpec = tween(500))
        alpha.animateTo(1f, animationSpec = tween(600))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .scale(scale.value)
                .alpha(alpha.value)
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            page.gradientColors[0].copy(alpha = 0.2f),
                            Color.Transparent
                        )
                    ),
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = page.icon,
                contentDescription = null,
                tint = page.gradientColors[0],
                modifier = Modifier.size(64.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = page.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.alpha(alpha.value)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = page.description,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White.copy(alpha = 0.7f),
            textAlign = TextAlign.Center,
            lineHeight = 24.sp,
            modifier = Modifier.alpha(alpha.value)
        )
    }
}

private data class OnboardingPage(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val gradientColors: List<Color>
)
