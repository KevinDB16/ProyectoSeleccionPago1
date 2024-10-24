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
        private val DATABASE_VERSION = 3
        private val TABLE_PAYMENTS = "Pagos"
        private val COLUMN_PAYMENT_ID = "id"
        private val COLUMN_PAYMENT_METHOD = "tipo"

        private val TABLE_PRODUCTS = "Productos"
        private val COLUMN_PRODUCT_ID = "id"
        private val COLUMN_PRODUCT_NAME = "nombre"
        private val COLUMN_PRODUCT_PRICE = "precio"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_PAYMENTS + " ("
                + COLUMN_PAYMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PAYMENT_METHOD + " TEXT)")

        val createTableProducts = ("CREATE TABLE " + TABLE_PRODUCTS + " ("
                + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_NAME + " TEXT)"
                + COLUMN_PRODUCT_PRICE + "REAL)")

        db.execSQL(createTable)
        db.execSQL(createTableProducts)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("CREATE TABLE IF EXISTS " + TABLE_PAYMENTS)
        db.execSQL("CREATE TABLE IF EXISTS " + TABLE_PRODUCTS)
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

    fun addProduct(name: String, price: String): Long{
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_PRODUCT_NAME, name)
            put(COLUMN_PRODUCT_PRICE, price)
        }
        val success = db.insert(TABLE_PRODUCTS, null, values)
        return success
    }
}