package com.uma.workmanagerdemo.ui.setalarm

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.uma.workmanagerdemo.R
import com.uma.workmanagerdemo.databinding.ActivityAlarmBinding
import com.uma.workmanagerdemo.worker.SampleWorker
import com.uma.workmanagerdemo.worker.WorkerA
import com.uma.workmanagerdemo.worker.WorkerB
import com.uma.workmanagerdemo.worker.WorkerC
import java.util.*
import java.util.concurrent.TimeUnit

class AlarmActivity : AppCompatActivity(), AlarmView {


    lateinit var activityAlarmBinding: ActivityAlarmBinding
    var periodical: PeriodicWorkRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityAlarmBinding = DataBindingUtil.setContentView(this, R.layout.activity_alarm)
        activityAlarmBinding.alarmBinding = AlarmViewModel(this)
    }

    override fun oneTimeRequest() {
        //Sending data....
        val data = Data.Builder()
        data.putString("Request", "one time request")
        data.putString("text", "one time request done by me:P")

        /**
         * Setting constrains to the work manager, system should satisfy the constraints to execute the request...
         */
        val constraints = Constraints.Builder().setRequiresCharging(true).build()
//        OneTimeWorkRequest.Builder(SampleWorker::class.java)
//            .build()
        val workerInstance =
            OneTimeWorkRequest.Builder(SampleWorker::class.java).setInputData(data.build()).build()
//            .setConstraints(constraints)
//            .build()

        WorkManager.getInstance(this).enqueue(workerInstance)
    }

    override fun cancelPeriodicalRequest() {

        if (periodical != null) {
            periodical?.id?.let { WorkManager.getInstance(this).cancelWorkById(it) }
            Toast.makeText(this, "Cancel work by its ID", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(
                this,
                "First click periodic request then only it will work",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun periodicalRequest() {

        /**
         * Sending data to work manager...
         */

        val data = Data.Builder()
        data.putString("Request", "request")
        data.putString("text", "Periodical request request done by me:P")
        periodical = PeriodicWorkRequest.Builder(SampleWorker::class.java, 15, TimeUnit.MINUTES)
            .addTag("cancel")
            .setInputData(data.build()).build()

        WorkManager.getInstance(this).enqueue(periodical!!)
    }

    override fun queuingWork() {

        val workerA = OneTimeWorkRequest.Builder(WorkerA::class.java)
            .addTag("queue1")
            .build()
        val workerB = OneTimeWorkRequest.Builder(WorkerB::class.java)
            .addTag("queue2")
            .build()
        val workerC = OneTimeWorkRequest.Builder(WorkerC::class.java)
            .addTag("queue3")
            .build()

        WorkManager.getInstance(this).beginWith(workerA).then(workerB).then(workerC)
            .enqueue()

    }

    override fun queuingWorkWithList() {
        val workerA = OneTimeWorkRequest.Builder(WorkerA::class.java)
            .addTag("WorkerA")
            .build()
        val workerB = OneTimeWorkRequest.Builder(WorkerB::class.java)
            .addTag("WorkerB")
            .build()
        val workerC = OneTimeWorkRequest.Builder(WorkerC::class.java)
            .addTag("WorkerC")
            .build()

        val list: MutableList<OneTimeWorkRequest> = mutableListOf()
        list.add(workerA)
        list.add(workerB)
        list.add(workerC)

        WorkManager.getInstance(this).beginWith(listOf(workerA, workerB)).then(workerC).enqueue()
    }

    override fun cancelWorkByTag() {
        val state = WorkManager.getInstance(this).cancelAllWorkByTag("cancel").state
        Toast.makeText(
            this,
            "Work state ${state.value}",
            Toast.LENGTH_SHORT
        ).show()
    }

    @SuppressLint("EnqueueWork")
    override fun worKWithChain() {

        val workerA = OneTimeWorkRequest.Builder(WorkerA::class.java)
            .addTag("WorkerA")
            .build()
        val workerB = OneTimeWorkRequest.Builder(WorkerB::class.java)
            .addTag("WorkerB")
            .build()
        val workerC = OneTimeWorkRequest.Builder(WorkerC::class.java)
            .addTag("WorkerC")
            .build()

        /**
         * Here @then returns new workContinuation instance every time...
         *
         * Combine will run ChainA and chainB operations parallel then executes .....
         */

        val chainA = WorkManager.getInstance(this).beginWith(workerC).then(workerB).then(workerA)
        val chainB = WorkManager.getInstance(this).beginWith(workerA).then(workerB).then(workerC)
        val stt = WorkContinuation.combine(mutableListOf(chainA,chainB)).enqueue()
        Log.e("status" , stt.result.toString())
    }
}
