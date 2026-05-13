package com.rork.pocketpaisa.data

import com.rork.pocketpaisa.data.model.*

object DemoData {

    val accounts = listOf(
        Account("1", "Savings Account", "HDFC Bank", "****4521", 128450.50, AccountType.BANK, color = 0xFF1E3A5F),
        Account("2", "Salary Account", "ICICI Bank", "****7823", 45600.00, AccountType.BANK, color = 0xFF2D5A27),
        Account("3", "Platinum Card", "SBI Card", "****9012", 23450.00, AccountType.CREDIT_CARD, cardNumber = "****9012", cardExpiry = "09/28", color = 0xFF8B4513),
        Account("4", "Paytm Wallet", "Paytm", "****3344", 3200.00, AccountType.WALLET, color = 0xFF0066CC),
        Account("5", "GPay UPI", "Google Pay", "****5566", 0.0, AccountType.UPI, color = 0xFF00AA66)
    )

    val transactions = listOf(
        Transaction("t1", 249.00, "Swiggy", TransactionCategory.FOOD, TransactionType.UPI, "2026-05-13", "19:30", "HDFC Bank", "Dinner order - Biryanis", "Late night food spending up 15%", false),
        Transaction("t2", 1299.00, "Amazon", TransactionCategory.SHOPPING, TransactionType.UPI, "2026-05-13", "14:15", "ICICI Bank", "Electronics purchase", null, false),
        Transaction("t3", 450.00, "Ola Cabs", TransactionCategory.TRANSPORT, TransactionType.UPI, "2026-05-12", "08:45", "HDFC Bank", "Office commute", null, false),
        Transaction("t4", 85.00, "Starbucks", TransactionCategory.FOOD, TransactionType.UPI, "2026-05-12", "10:20", "ICICI Bank", "Morning coffee", "Daily coffee spend is Rs 85 avg", false),
        Transaction("t5", 25000.00, "ABC Corp", TransactionCategory.SALARY, TransactionType.CREDIT, "2026-05-01", "09:00", "HDFC Bank", "Monthly salary credit", null, false),
        Transaction("t6", 899.00, "Netflix", TransactionCategory.ENTERTAINMENT, TransactionType.UPI, "2026-05-10", "00:01", "ICICI Bank", "Monthly subscription", "Subscription renewing in 20 days", true),
        Transaction("t7", 1499.00, "Swiggy", TransactionCategory.FOOD, TransactionType.UPI, "2026-05-11", "20:00", "HDFC Bank", "Weekend dinner", "Food spending increased 12%", false),
        Transaction("t8", 3500.00, "PharmEasy", TransactionCategory.HEALTHCARE, TransactionType.UPI, "2026-05-09", "16:30", "HDFC Bank", "Medicines", null, false),
        Transaction("t9", 15000.00, "Rent", TransactionCategory.RENT, TransactionType.UPI, "2026-05-05", "10:00", "ICICI Bank", "Monthly rent", null, false),
        Transaction("t10", 5000.00, "Mutual Fund SIP", TransactionCategory.INVESTMENTS, TransactionType.UPI, "2026-05-05", "08:00", "HDFC Bank", "Monthly SIP", "Investment discipline maintained", false),
        Transaction("t11", 199.00, "Spotify", TransactionCategory.ENTERTAINMENT, TransactionType.UPI, "2026-05-08", "00:01", "ICICI Bank", "Monthly subscription", null, true),
        Transaction("t12", 2000.00, "Electricity Bill", TransactionCategory.BILLS, TransactionType.UPI, "2026-05-07", "11:00", "HDFC Bank", "BESCOM", null, false),
        Transaction("t13", 500.00, "ATM Withdrawal", TransactionCategory.OTHER, TransactionType.ATM, "2026-05-06", "18:30", "HDFC Bank", "Cash withdrawal", null, false),
        Transaction("t14", 1200.00, "PVR Cinemas", TransactionCategory.ENTERTAINMENT, TransactionType.UPI, "2026-05-04", "19:00", "ICICI Bank", "Movie tickets", null, false),
        Transaction("t15", 320.00, "Zepto", TransactionCategory.FOOD, TransactionType.UPI, "2026-05-03", "21:00", "HDFC Bank", "Groceries", null, false)
    )

    val subscriptions = listOf(
        Subscription("s1", "Netflix", 899.0, BillingCycle.MONTHLY, "2026-06-10", "Entertainment"),
        Subscription("s2", "Spotify", 199.0, BillingCycle.MONTHLY, "2026-06-08", "Entertainment"),
        Subscription("s3", "ChatGPT Plus", 1950.0, BillingCycle.MONTHLY, "2026-06-15", "Productivity"),
        Subscription("s4", "YouTube Premium", 129.0, BillingCycle.MONTHLY, "2026-06-01", "Entertainment"),
        Subscription("s5", "Amazon Prime", 1499.0, BillingCycle.YEARLY, "2026-08-15", "Shopping"),
        Subscription("s6", "Notion", 800.0, BillingCycle.MONTHLY, "2026-06-20", "Productivity"),
        Subscription("s7", "Disney+ Hotstar", 1499.0, BillingCycle.YEARLY, "2026-09-10", "Entertainment")
    )

    val budgets = listOf(
        Budget("b1", TransactionCategory.FOOD, 8000.0, 5408.0, "May", 2026),
        Budget("b2", TransactionCategory.SHOPPING, 5000.0, 1299.0, "May", 2026),
        Budget("b3", TransactionCategory.ENTERTAINMENT, 3000.0, 3298.0, "May", 2026),
        Budget("b4", TransactionCategory.TRANSPORT, 2000.0, 450.0, "May", 2026),
        Budget("b5", TransactionCategory.BILLS, 3000.0, 2000.0, "May", 2026)
    )

    val insights = listOf(
        Insight("i1", "Food spending up 12%", "You spent Rs 5,408 on food this month, up from Rs 4,820 last month. Consider setting a stricter dining budget.", InsightType.SPENDING, InsightSeverity.WARNING, "Set Budget"),
        Insight("i2", "3 subscriptions renewing soon", "Netflix, Spotify, and ChatGPT Plus renew in the next 15 days. Total: Rs 3,048.", InsightType.SUBSCRIPTION, InsightSeverity.INFO, "View Subscriptions"),
        Insight("i3", "You're under budget on transport", "Great job! Transport spending is only 22% of your budget.", InsightType.BUDGET, InsightSeverity.POSITIVE, "View Budget"),
        Insight("i4", "Investment milestone reached", "Your monthly SIP of Rs 5,000 has been consistent for 12 months. Total invested: Rs 60,000.", InsightType.INVESTMENT, InsightSeverity.POSITIVE, null),
        Insight("i5", "Unusual spending detected", "Rs 3,500 spent at PharmEasy - 5x your usual pharmacy spend.", InsightType.FRAUD, InsightSeverity.CRITICAL, "Review Transaction")
    )

    val chatMessages = listOf(
        ChatMessage("c1", "Hi! I'm PocketPaisa AI, your personal financial assistant. I can help you analyze spending, find savings, and track your money. What would you like to know?", false, "10:00 AM"),
        ChatMessage("c2", "How much did I spend this month?", true, "10:01 AM"),
        ChatMessage("c3", "You've spent Rs 28,903 so far in May. Your top categories are Food (Rs 5,408), Rent (Rs 15,000), and Entertainment (Rs 4,497). You're currently 18% over your monthly budget.", false, "10:01 AM", true, "View Breakdown"),
        ChatMessage("c4", "Where can I save money?", true, "10:02 AM"),
        ChatMessage("c5", "I found 3 potential savings: 1) Your food delivery spending is Rs 3,500 - cooking at home could save Rs 2,000/month. 2) You have unused subscriptions worth Rs 2,349/year. 3) Switching your mobile plan could save Rs 200/month.", false, "10:02 AM", true, "Take Action")
    )

    val savingsGoals = listOf(
        SavingsGoal("sg1", "Emergency Fund", 200000.0, 85000.0, "2026-12-31", "Shield"),
        SavingsGoal("sg2", "New Laptop", 120000.0, 45000.0, "2026-08-15", "Laptop"),
        SavingsGoal("sg3", "Vacation Fund", 100000.0, 22000.0, "2027-03-01", "Flight")
    )
}
