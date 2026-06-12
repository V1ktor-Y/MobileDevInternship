package com.example.csoft.domain

import com.example.csoft.data.DummyData

class DummyDataService(val dummyRepo: DummyData) {
    fun getTransactions() = dummyRepo.getTransactions()

    // this should probably be converted to some currency and THEN used
    fun getLargestTransaction() = dummyRepo.getTransactions().maxByOrNull { it.sum }

    fun getTotalSpent() = dummyRepo.getTransactions().sumOf { it.sum }
}