package com.uma.workmanagerdemo.worker

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.uma.workmanagerdemo.R


/**
 * Created by Umapathi on 2019-09-13.
 * Copyright Indyzen Inc, @2019
 */
class SampleWorker(var ctx: Context, workerParams: WorkerParameters) : Worker(ctx, workerParams) {

    override fun doWork(): Result {

        val request = inputData.getString("Request")
        val text = inputData.getString("text")

        Log.e("Do work", "Sample worker")
//        Toast.makeText(ctx,"Under construction.....",Toast.LENGTH_SHORT).show()
        val channelId = "Uma"
        val n = NotificationCompat.Builder(ctx, channelId)
            .setSmallIcon(R.drawable.ic_android)
            .setColor(Color.RED)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentTitle(request)
            .setContentText(text)
            .setStyle(NotificationCompat.BigTextStyle().bigText(text))

        with(NotificationManagerCompat.from(ctx)) {
            // notificationId is a unique int for each notification that you must define
            notify(123, n.build())
        }
        return Result.success()
    }
}