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

class Chemistry : AppCompatActivity()
{
    var downloadID : Long =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chemistry)

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
                Uri.parse("https://drive.google.com/uc?export=download&id=1zwTTCXvkuj_FhUYdXNNXCyXXRkf8ypt0"))
                .setTitle("Atkins’ Physical Chemistry")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Atkins’ Physical Chemistry.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile2(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=108eZR1PywG41Eul8wKnANEpbI3hhSJwG"))
                .setTitle("Organic Chemistry")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Organic Chemistry.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile3(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=16QNzBexVpealEybjnwlyNlTBIcXP_4cj"))
                .setTitle("Quantum Chemistry")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "Quantum Chemistry.pdf");

        var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        downloadID= dm.enqueue(request)

    }

    fun downloadFile4(view:View)
    {
        var request= DownloadManager.Request(
                Uri.parse("https://drive.google.com/uc?export=download&id=1AOj4M1vKbD2nDXtTPc5Lyf9_ILrhrYns"))
                .setTitle("The Elements A Very Short Introduction")
                .setDescription("File Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)
                .setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, "The Elements A Very Short Introduction.pdf");

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