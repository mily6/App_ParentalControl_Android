package pwr.aplikacja_dat

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object LoginSchema {
    object LoginEntry : BaseColumns {
        const val TABLE_NAME = "logreg"
        const val COLUMN_NAME_LOGIN = "login"
        const val COLUMN_NAME_PASSWORD = "password"
        const val COLUMN_NAME_EMAIL = "email"
    }
}

object MenuSchema {
    object MenuEntry : BaseColumns {
        const val TABLE_NAME = "menu"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_IP = "ip"
        const val COLUMN_NAME_STATE = "state"
        const val COLUMN_NAME_CONNECTIME = "connectime"
        const val COLUMN_NAME_USEDATA = "usedata"
    }
}

object DeviceSchema {
    object DeviceEntry : BaseColumns {
        const val TABLE_NAME = "device"
        const val COLUMN_NAME_CONNECTED = "connected"
        const val COLUMN_NAME_LIMIT = "limity"
        const val COLUMN_NAME_DISCONNECTIONTIME = "disconnectiontime"
        const val COLUMN_NAME_CONNECTIONTIME = "connectiontime"
        const val COLUMN_NAME_LASTUSED = "lastused"
        const val COLUMN_NAME_LASTACTIVITY = "lastactivity"
    }
}

object StatisticSchema {
    object StatisticEntry : BaseColumns {
        const val TABLE_NAME = "statistic"
        const val COLUMN_NAME_DAILY = "daily"
        const val COLUMN_NAME_WEEKLY = "weekly"
        const val COLUMN_NAME_MONTHLY = "monthly"
        const val COLUMN_NAME_PREVMONTHLY = "prevmonthly"
    }
}

private const val logreg_create = "CREATE TABLE ${LoginSchema.LoginEntry.TABLE_NAME} (" +
        "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
        "${LoginSchema.LoginEntry.COLUMN_NAME_LOGIN} TEXT," +
        "${LoginSchema.LoginEntry.COLUMN_NAME_PASSWORD} TEXT," +
        "${LoginSchema.LoginEntry.COLUMN_NAME_EMAIL} TEXT)"

private const val menu_create = "CREATE TABLE ${MenuSchema.MenuEntry.TABLE_NAME} (" +
        "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
        "${MenuSchema.MenuEntry.COLUMN_NAME_NAME} TEXT," +
        "${MenuSchema.MenuEntry.COLUMN_NAME_IP} TEXT," +
        "${MenuSchema.MenuEntry.COLUMN_NAME_STATE} TEXT," +
        "${MenuSchema.MenuEntry.COLUMN_NAME_CONNECTIME} TEXT," +
        "${MenuSchema.MenuEntry.COLUMN_NAME_USEDATA} TEXT)"

private const val device_create = "CREATE TABLE ${DeviceSchema.DeviceEntry.TABLE_NAME} (" +
        "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
        "${DeviceSchema.DeviceEntry.COLUMN_NAME_CONNECTED} TEXT," +
        "${DeviceSchema.DeviceEntry.COLUMN_NAME_LIMIT} TEXT," +
        "${DeviceSchema.DeviceEntry.COLUMN_NAME_DISCONNECTIONTIME} TEXT," +
        "${DeviceSchema.DeviceEntry.COLUMN_NAME_CONNECTIONTIME} TEXT," +
        "${DeviceSchema.DeviceEntry.COLUMN_NAME_LASTUSED} TEXT," +
        "${DeviceSchema.DeviceEntry.COLUMN_NAME_LASTACTIVITY} TEXT)"

private const val static_create = "CREATE TABLE ${StatisticSchema.StatisticEntry.TABLE_NAME} (" +
        "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
        "${StatisticSchema.StatisticEntry.COLUMN_NAME_DAILY} TEXT," +
        "${StatisticSchema.StatisticEntry.COLUMN_NAME_WEEKLY} TEXT," +
        "${StatisticSchema.StatisticEntry.COLUMN_NAME_MONTHLY} TEXT,"+
        "${StatisticSchema.StatisticEntry.COLUMN_NAME_PREVMONTHLY} TEXT)"

private const val logreg_delete = "DROP TABLE IF EXISTS ${LoginSchema.LoginEntry.TABLE_NAME}"
private const val menu_delete = "DROP TABLE IF EXISTS ${MenuSchema.MenuEntry.TABLE_NAME}"
private const val device_delete = "DROP TABLE IF EXISTS ${DeviceSchema.DeviceEntry.TABLE_NAME}"
private const val static_delete = "DROP TABLE IF EXISTS ${StatisticSchema.StatisticEntry.TABLE_NAME}"

class Database(context: Context) : SQLiteOpenHelper(context, "AppBase.db", null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(logreg_create)
        db?.execSQL(menu_create)
        db?.execSQL(device_create)
        db?.execSQL(static_create)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(logreg_delete)
        db?.execSQL(menu_delete)
        db?.execSQL(device_delete)
        db?.execSQL(static_delete)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}