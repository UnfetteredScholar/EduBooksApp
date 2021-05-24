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

class Biology : AppCompatActivity()
{
    var downloadID : Long =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biology)

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
                Uri.parse("https://drive.google.com/uc?export=download&id=1y5vkOzXqOw87ydQH2PgRFhonR77z0BUH"))
                .setTitle(" Ken Schultz's Field Guide to Freshwater Fish")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, " Ken Schultz's Field Guide to Freshwater Fish.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile2(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1gcn_ch0UnpL8u0VE4soNC1JB54BlA77d"))
                .setTitle("Ken Schultz's Field Guide to Saltwater Fish")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Ken Schultz's Field Guide to Saltwater Fish.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile3(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1NwMQKVwgm7P2efHgWrZjHrER_D9E0qm7"))
                .setTitle("Anatomy 101")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Anatomy 101.epub");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile4(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1hehTcJ-Q9FM1nYQAy_k9ZBVq2XtK6qtZ"))
                .setTitle("Behave The Biology of Humans at Our Best and Worst")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Behave The Biology of Humans at Our Best and Worst.epub");

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