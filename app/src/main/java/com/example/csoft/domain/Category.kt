package com.example.csoft.domain

import com.example.csoft.R

enum class Category(val icon: Int) {
    FOOD(R.drawable.ic_fork_knife),
    ENTERTAINMENT(R.drawable.ic_tv),
    BILLS(R.drawable.ic_bill),
    SUBSCRIPTIONS(R.drawable.ic_subscription),
    PEOPLE(R.drawable.ic_people),
    OTHER(R.drawable.ic_question_mark_star),
}