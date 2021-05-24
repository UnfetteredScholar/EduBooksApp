package com.example.edubooksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RequestBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_book)
    }

    fun requestBook(view: View)
    {
        val context= this

        val title= findViewById<EditText>(R.id.btitle)
        val author= findViewById<EditText>(R.id.author)
        val publisher= findViewById<EditText>(R.id.publisher)

        if(title.length()>0 && author.length()>0 && publisher.length()>0)
        {
            var request= Request(title.text.toString(), author.text.toString(), publisher.text.toString());
            var db= DatabaseHandler(context);

            var suc= db.insertData2(request);

            if(suc==1)
            {

                //MOVE TO CATEGORIES
                val intent= Intent(this, Homepage::class.java)
                startActivity(intent);
            }
        }
        else
        {
            Toast.makeText(context, "All Fields Are Required", Toast.LENGTH_SHORT).show()
        }
    }

}