package com.example.seleccionpago

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class PaymentDatabaseHelper(context:Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{
    companion object{
        private val DATABASE_NAME = "PAGOS.db"
        private val DATABASE_VERSION = 2
        private val TABLE_PAYMENTS = "Pagos"
        private val COLUMN_ID = "id"
        private val COLUMN_PAYMENT_METHOD = "tipo"
        private val COLUMN_DNI = "dni"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_PAYMENTS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PAYMENT_METHOD + " TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENTS)
        onCreate(db)
    }

    fun addPaymentMethod(paymentMethod: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_PAYMENT_METHOD, paymentMethod)
        }
        val success = db.insert(TABLE_PAYMENTS, null, values)
        return success
    }
}