package com.example.csoft.domain

import com.example.csoft.data.DummyData
import com.example.csoft.data.TransactionsRepository

class DummyDataService(val dummyRepo: TransactionsRepository) : TransactionService {
    override fun getTransactions() = dummyRepo.getTransactions() ?: listOf(
        Transaction(-1, "N/A", 0.0, Currency.USD, Category.OTHER)
    )

    // TODO: this should probably be converted to some specific currency and THEN used
    override fun getLargestTransaction(): Transaction {
        val transaction = dummyRepo.getLargestTransaction()
        return transaction ?: Transaction(-1, "N/A", 0.0, Currency.USD, Category.OTHER)
    }

    override fun getTotalSpentTransaction(): Transaction {
        // TODO: change this to some currency and then sum it
        val totalSum = dummyRepo.getTotalSpentTransaction() ?: 0.0
        return Transaction(0, "Total", totalSum, Currency.USD, Category.OTHER)
    }
}