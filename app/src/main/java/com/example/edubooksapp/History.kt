package com.example.edubooksapp

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Environment.DIRECTORY_DOWNLOADS
import android.view.View
import android.widget.Toast
import java.io.File

class History : AppCompatActivity()
{
    var downloadID : Long =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        var br= object:BroadcastReceiver()
        {
            override fun onReceive(context: Context?, intent: Intent?)
            {
                var id= intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)

                if(id==downloadID)
                {
                    Toast.makeText(applicationContext, "Download Complete", Toast.LENGTH_LONG).show()
                }
            }
        }

    }


    fun downloadFile1(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1W2IuuzCgK9QnRg9NX_Cjo_J-JJh2rTZv"))
                .setTitle("The History of Thought")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "The History of Thought.epub");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile2(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1-N0x-8KVh4410CJXIXO36gSiSdrER5DR"))
                .setTitle("Homo Deus A Brief History of Tomorrow")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Homo Deus A Brief History of Tomorrow.epub");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile3(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1_Jio36Or9Zqmei0GOiWWyn8Zvk6UE7_I"))
                .setTitle("A Brief History of Time From Big Bang to Black Holes")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "A Brief History of Time From Big Bang to Black Holes.epub");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile4(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1rTYKl07g_BuryO00Dw8Z_Y7sEUPWaGLD"))
                .setTitle("Sapiens A Brief History of Humankind")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Sapiens A Brief History of Humankind.epub");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun moveToRequests(view: View)
    {
        //MOVE TO REQUESTS
        val intent = Intent(this, RequestBook::class.java)
        startActivity(intent)
    }



}