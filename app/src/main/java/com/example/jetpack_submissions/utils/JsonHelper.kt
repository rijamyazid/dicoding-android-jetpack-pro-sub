package com.example.jetpack_submissions.utils

import android.content.Context
import java.io.IOException

object JsonHelper {

    fun parsingFileToString(context: Context, fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

}