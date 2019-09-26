package com.uma.workmanagerdemo

import android.util.Log
import com.uma.workmanagerdemo.worker.SampleWorker
import org.junit.Test
import androidx.work.testing.TestListenableWorkerBuilder

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

//    @Test
//    fun codeMeasurement() {
//        val worker = TestListenableWorkerBuilder<SampleWorker>(context).build() //jetpack workmanager library
//        val start = java.lang.System.nanoTime() //for starting time of work
//        worker.doWork() //do some work i.e. code to be measured
//        val elapsed = (java.lang.System.nanoTime() - start) //time taken to complete the work
//        Log.d("Code Measurement", "Time taken was $elapsed ns")
//    }
}
