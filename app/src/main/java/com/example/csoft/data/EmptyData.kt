package com.example.csoft.data

import com.example.csoft.domain.Category
import com.example.csoft.domain.Transaction

class EmptyData : TransactionsRepository{
    override fun getTransactions(): List<Transaction>? {
        return null
    }

    override fun getLargestTransaction(): Transaction? {
        return null
    }

    override fun getTotalSpentTransaction(): Double? {
        return null
    }

    override fun getCategorySum(category: Category): Double? {
        return null
    }
}