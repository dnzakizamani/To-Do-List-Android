package com.ppb.note.util

import android.text.Editable
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter


object Utilities {
    fun LocalDate.formatToString(): String {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd LLL")
        return this.format(dateTimeFormatter)
    }

    fun String.formatToDate(): String {
        val localDate = LocalDate.parse(this)
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd LLL")
        return localDate.format(dateTimeFormatter)
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}