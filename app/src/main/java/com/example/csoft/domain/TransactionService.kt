package com.example.csoft.domain

interface TransactionService {
    fun getTransactions(): List<Transaction>
    fun getLargestTransaction(): Transaction
    fun getTotalSpentTransaction(): Transaction

    fun getCategoryPercent(category: Category): Double
}