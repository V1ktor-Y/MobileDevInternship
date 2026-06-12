package com.example.csoft.data

import com.example.csoft.domain.Category
import com.example.csoft.domain.Currency
import com.example.csoft.domain.Transaction

class DummyData {
    private val transactions = listOf<Transaction>(
        Transaction(
            recipient = "Peter",
            sum = 299.0,
            currency = Currency.USD,
            category = Category.PEOPLE
        ), Transaction(
            recipient = "Doofenshmirtz Evil inc.",
            sum = 499.0,
            currency = Currency.EURO,
            category = Category.BILLS
        ), Transaction(
            recipient = "Subway",
            sum = 7.40,
            currency = Currency.EURO,
            category = Category.FOOD
        ), Transaction(
            recipient = "Netflix",
            sum = 12.99,
            currency = Currency.USD,
            category = Category.SUBSCRIPTIONS
        ),
        Transaction(
            recipient = "\$BTC",
            sum = 199.0,
            currency = Currency.USD,
            category = Category.OTHER
        )
    )

    fun connect(): Unit {
        println("Beep boop. Connected to db")
    }

    fun getTransactions() = transactions;

}