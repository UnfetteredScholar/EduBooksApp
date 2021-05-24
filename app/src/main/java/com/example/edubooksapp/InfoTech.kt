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

class InfoTech : AppCompatActivity()
{
    var downloadID : Long =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_tech)

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
                Uri.parse("https://drive.google.com/uc?export=download&id=1xFLX5k_SA5GzFFrHWm9gri37eFV31KNR"))
                .setTitle("Learning C# Language")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Learning Cs Language.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile2(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1ywSO8Cy8wv0KaPyP1elaDjF-kqd8mibE"))
                .setTitle("HTML CSS- Design and Build Websites")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "HTML CSS- Design and Build Websites.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile3(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1OAQIUAS0EoT2SHuXRCFMehIlv20uPmWO"))
                .setTitle("C++ Primer Plus")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "C++ Primer Plus.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile4(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1YgXlJ7Zc884ssu87DVUJNGySQSrniAdW"))
                .setTitle("Teach Yourself C++ in 24 Hours")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Teach Yourself C++ in 24 Hours.pdf");

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