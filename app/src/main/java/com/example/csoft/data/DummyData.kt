package com.example.csoft.data

import com.example.csoft.domain.Category
import com.example.csoft.domain.Currency
import com.example.csoft.domain.Transaction
import kotlin.collections.sumOf

class DummyData : TransactionsRepository {
    private var currentId = 1
    private val transactions = listOf<Transaction>(
        Transaction(
            recipient = "Peter",
            sum = 299.0,
            currency = Currency.USD,
            category = Category.PEOPLE,
            id = currentId++
        ), Transaction(
            recipient = "Doofenshmirtz Evil inc.",
            sum = 499.0,
            currency = Currency.EURO,
            category = Category.BILLS,
            id = currentId++
        ), Transaction(
            recipient = "Subway",
            sum = 7.40,
            currency = Currency.EURO,
            category = Category.FOOD,
            id = currentId++
        ), Transaction(
            recipient = "Netflix",
            sum = 12.99,
            currency = Currency.USD,
            category = Category.SUBSCRIPTIONS,
            id = currentId++
        ),
        Transaction(
            recipient = "\$BTC",
            sum = 199.0,
            currency = Currency.USD,
            category = Category.OTHER,
            id = currentId++
        )
    )

    fun connect(): Unit {
        println("Beep boop. Connected to db")
    }

    override fun getTransactions(): List<Transaction>? = transactions;

    override fun getLargestTransaction(): Transaction? {
        return transactions?.maxByOrNull { it.sum }
    }

    override fun getTotalSpentTransaction(): Double? {
        return transactions?.sumOf { it.sum }
    }

    override fun getCategorySum(category: Category): Double? {
        return transactions?.filter { it.category == category }?.sumOf { it.sum }
    }

}