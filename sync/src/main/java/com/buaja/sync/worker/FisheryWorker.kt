package com.buaja.sync.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.buaja.sync.domain.repository.SyncFisheryRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


/**
 * @created 06/03/22 10.21
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@HiltWorker
class FisheryWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val syncFisheryRepository: SyncFisheryRepository
): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {

        return try {
            syncFisheryRepository.syncData()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}