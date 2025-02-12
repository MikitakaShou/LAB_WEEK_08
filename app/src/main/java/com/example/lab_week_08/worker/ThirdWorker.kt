package com.example.lab_week_08.worker

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class ThirdWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    // This function executes the predefined process based on the input
    // and return an output after it's done
    override fun doWork(): Result {
        // Get the parameter input
        val id = inputData.getString(INPUT_DATA_ID)

        // Sleep the process for 3 seconds
        Thread.sleep(3000L)

        // Build the output based on process result
        val outputData = Data.Builder()
            .putString(OUTPUT_DATA_ID, id)
            .build()

        // Return the output
        return Result.success(outputData)
    }



    companion object {
        const val INPUT_DATA_ID = "input_data_id"
        const val OUTPUT_DATA_ID = "output_data_id"
    }
}