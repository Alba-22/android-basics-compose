package com.example.unscramble.ui.test

import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import com.example.unscramble.ui.GameViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        // Arrange
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        // Act
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        // Assert
        currentGameUiState = viewModel.uiState.value
        assertFalse(currentGameUiState.isGuessedWordWrong)
        assertEquals(currentGameUiState.score, SCORE_AFTER_FIRST_CORRECT_ANSWER)
    }

    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        // Arrange
        val incorrectPlayerWord = "and"
        var currentGameUiState = viewModel.uiState.value
        val scoreBeforeGuess = currentGameUiState.score

        // Act
        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        // Assert
        currentGameUiState = viewModel.uiState.value
        assertTrue(currentGameUiState.isGuessedWordWrong)
        assertEquals(currentGameUiState.score, scoreBeforeGuess)

    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        val gameUiState = viewModel.uiState.value

        assertEquals(gameUiState.currentWordCount, 1)
        assertEquals(gameUiState.score, 0)
        assertFalse(gameUiState.isGuessedWordWrong)
        assertFalse(gameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        repeat(MAX_NO_OF_WORDS) {
            expectedScore += SCORE_INCREASE
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
            assertEquals(expectedScore, currentGameUiState.score)
        }

        assertEquals(MAX_NO_OF_WORDS, currentGameUiState.currentWordCount)
        assertTrue(currentGameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased() {
        // Arrange
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
        currentGameUiState = viewModel.uiState.value
        val scoreBeforeTest = currentGameUiState.score
        val wordCountBeforeTest = currentGameUiState.currentWordCount

        // Act
        viewModel.skipWord()

        // Assert
        currentGameUiState = viewModel.uiState.value
        assertEquals(currentGameUiState.score, scoreBeforeTest)
        assertEquals(currentGameUiState.currentWordCount, wordCountBeforeTest.inc())
    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}