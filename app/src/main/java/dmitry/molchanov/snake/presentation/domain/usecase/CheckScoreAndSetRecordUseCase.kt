package dmitry.molchanov.snake.presentation.domain.usecase

import dmitry.molchanov.preference.RecordDataStore
import dmitry.molchanov.snake.presentation.domain.CoroutineDispatchers
import kotlinx.coroutines.withContext

class CheckScoreAndSetRecordUseCase(
    private val prefRepository: RecordDataStore,
    private val coroutineDispatchers: CoroutineDispatchers
) {

    suspend fun execute(score: Int): Unit = withContext(coroutineDispatchers.io) {
        if (prefRepository.currentRecord < score) {
            prefRepository.currentRecord = score
        }
    }
}
