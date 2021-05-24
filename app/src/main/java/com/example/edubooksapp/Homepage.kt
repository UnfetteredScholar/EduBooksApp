package com.example.edubooksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Homepage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
    }

    fun moveToBio(view: View) {
        //move to the biology page
        val intent = Intent(this, Biology::class.java)

        startActivity(intent)
    }

    fun moveToChem(view: View) {
        //move to the chemistry page
        val intent = Intent(this, Chemistry::class.java)

        startActivity(intent)
    }

    fun moveToPhys(view: View) {
        //move to the physics page
        val intent = Intent(this, Physics::class.java)

        startActivity(intent)
    }
    fun moveToIT(view: View) {
        //move to the IT page
        val intent = Intent(this,InfoTech::class.java)

        startActivity(intent)
    }

    fun moveToMath(view: View) {
        //move to the mathematics page
        val intent = Intent(this, Math::class.java)

        startActivity(intent)
    }

    fun moveToHis(view: View) {
        //move to the history page
        val intent = Intent(this, History::class.java)

        startActivity(intent)
    }


}