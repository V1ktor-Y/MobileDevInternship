package com.example.csoft.domain

class Transaction(
    //val sender: String,
    val recipient: String,
    val sum: Double,
    val currency: Currency,
    val category: Category
) {
}