package ru.ama.ottest.domain.usecase

import ru.ama.ottest.domain.entity.GameSettings
import ru.ama.ottest.domain.repository.GameRepository
import javax.inject.Inject

class GetGameSettingsUseCase  @Inject constructor(
    private val gameRepository: GameRepository
) {

    operator fun invoke(): GameSettings = gameRepository.getGameSettings()
}
