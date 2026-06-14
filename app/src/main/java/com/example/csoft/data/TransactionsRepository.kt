package com.example.csoft.data

import com.example.csoft.domain.Category
import com.example.csoft.domain.Transaction

interface TransactionsRepository {
    fun getTransactions(): List<Transaction>?
    fun getLargestTransaction(): Transaction?
    fun getTotalSpentTransaction(): Double?

    fun getCategorySum(category: Category): Double?
}