package com.uma.workmanagerdemo.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by Umapathi on 2019-09-19.
 * Copyright Indyzen Inc, @2019
 */
class WorkerC(var context: Context , var workerParameters: WorkerParameters ) : Worker(context,workerParameters) {

    override fun doWork(): Result {

        Log.e("WorkerC","WorkerC")
        return Result.success()
    }
}