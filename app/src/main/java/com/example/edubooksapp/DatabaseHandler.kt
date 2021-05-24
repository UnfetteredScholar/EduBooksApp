package com.example.edubooksapp


import android.content.ContentValues
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


const val  DBNAME= "Edu-BooksApp"
const val TABLE_NAME= "users"
const val COL_UNAME= "username"
const val COL_EMAIL= "email"
const val COL_PASSWORD= "password"

const val TABLE_NAME2= "requests"
const val COL_TITLE= "book_title"
const val COL_AUTHOR= "author"
const val COL_PUBLISHER= "publisher"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DBNAME, null, 1)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        val createTable= "CREATE TABLE "+ TABLE_NAME + " ("+
                COL_EMAIL+ " VARCHAR(256) PRIMARY KEY UNIQUE, "+
                COL_UNAME+ " VARCHAR(256) UNIQUE, "+
                COL_PASSWORD+ " VARCHAR(256))";

        val createTable2= "CREATE TABLE "+ TABLE_NAME2+ " ("+
                COL_TITLE+ " VARCHAR(256), "+
                COL_AUTHOR+ " VARCHAR(256), "+
                COL_PUBLISHER+ " VARCHAR(256) )";

        db?.execSQL(createTable)
        db?.execSQL(createTable2)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user:User) : Int
    {
        val db= this.writableDatabase

        val cv= ContentValues()

        cv.put(COL_EMAIL, user.email)
        cv.put(COL_UNAME, user.username)
        cv.put(COL_PASSWORD, user.password1)

        val result= db.insert(TABLE_NAME, null ,cv)

        if(result == -1.toLong())
        {
            Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()
            return 0;
        }
        else
        {
            Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
            return 1;
        }
    }

    fun readData(user:User) : Int
    {

        val db= this.readableDatabase

        val query = "SELECT * FROM " + TABLE_NAME

        val result = db.rawQuery(query, null)

        var count = DatabaseUtils.queryNumEntries(db, TABLE_NAME)

        var validate=0;

        result.moveToFirst()

        while(count>0)
        {
            if((user.username.toString() == result.getString(result.getColumnIndex(COL_UNAME)).toString()) && (user.password1.toString()== result.getString(result.getColumnIndex(COL_PASSWORD)).toString()) )
            {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                validate= 1;
                return 1;
            }
            result.moveToNext()
            count -= 1;
        }

        if(validate==0)
        {

            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            return 0;
        }

        return  0;

    }

    fun insertData2(request: Request) : Int
    {
        val db= this.writableDatabase

        val cv= ContentValues()

        cv.put(COL_TITLE, request.title)
        cv.put(COL_AUTHOR, request.author)
        cv.put(COL_PUBLISHER, request.publisher)

        val result= db.insert(TABLE_NAME2,null, cv);

        if(result==-1.toLong())
        {
            Toast.makeText(context, "Request Failed", Toast.LENGTH_SHORT).show()
            return 0;
        }
        else
        {
            Toast.makeText(context, "Request Sent", Toast.LENGTH_SHORT).show()
            return 1;
        }

    }


}
