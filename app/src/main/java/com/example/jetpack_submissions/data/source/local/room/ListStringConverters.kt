package com.example.jetpack_submissions.data.source.local.room

import androidx.room.TypeConverter

object ListStringConverters {

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>): String {
        return listOfString.joinToString(",")
    }

    @TypeConverter
    fun toListOfStrings(flatStringList: String): List<String> {
        return flatStringList.split(",")
    }

}