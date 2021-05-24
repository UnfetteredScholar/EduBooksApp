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

class Physics : AppCompatActivity()
{
    var downloadID : Long =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)

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
                Uri.parse("https://drive.google.com/uc?export=download&id=1AU5m99sOyXiCfOqwuIMvJbY_xam9il1h"))
                .setTitle("Physics for Engineers and Scientists")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Physics for Engineers and Scientists.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile2(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1gaY6CtiTOaJX4NFZK_oZi44syZzluNQE"))
                .setTitle("Physics for Scientists Engineers with Modern Physics")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Physics for Scientists Engineers with Modern Physics.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile3(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=15r6JLxuJB_npZh8i7KQP04LgDfWvfIax"))
                .setTitle("Fundamentals of Physics")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Fundamentals of Physics.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile4(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1zNdfoxb01oR01loVGAhT1_Hgou6ykUZo"))
                .setTitle("Instructor Solution Manual for Fundamentals of Physics")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Instructor Solution Manual for Fundamentals of Physics.pdf");

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