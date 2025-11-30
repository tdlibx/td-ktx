package com.telegramflow.example.domain.files

import com.telegramflow.example.data.repo.TelegramRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Singleton
class DownloadFileUseCase @Inject constructor(
    private val telegramRepository: TelegramRepository,
) {
    suspend operator fun invoke(fileId: Int): String? = withContext(Dispatchers.IO) {
        val downloaded = telegramRepository.downloadFile(
            fileId = fileId,
            priority = 1,
            offset = 0L,
            limit = 0L,
            synchronous = true,
        )

        downloaded.local?.takeIf { it.isDownloadingCompleted }?.path?.takeIf { it.isNotBlank() }
    }
}
