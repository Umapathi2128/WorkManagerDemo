package com.uma.benchmark

import android.util.Log
import androidx.benchmark.BenchmarkRule
import androidx.benchmark.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

/**
 * Benchmark, which will execute on an Android device.
 *
 * The body of [BenchmarkRule.measureRepeated] is measured in a loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun log() {
        try {
            benchmarkRule.measureRepeated {
                Log.d("LogBenchmark", "the cost of writing this log method will be measured")
            }
        }catch (e: Exception){
            e.printStackTrace()
            Log.e("Chumma","${e.message}")
        }
    }
}