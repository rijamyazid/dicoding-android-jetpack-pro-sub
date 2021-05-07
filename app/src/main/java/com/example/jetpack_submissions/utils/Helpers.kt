package com.example.jetpack_submissions.utils

object Helpers {

    fun getYearFromDate(date: String): String {
        return date.split('-')[0]
    }

    fun inverseDate(date: String): String {
        return date.split('-').reversed().joinToString(separator = "-")
    }

}