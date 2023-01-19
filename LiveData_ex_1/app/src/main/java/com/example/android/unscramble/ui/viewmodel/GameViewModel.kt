package com.example.android.unscramble.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.android.unscramble.ui.game.MAX_NO_OF_WORDS
import com.example.android.unscramble.ui.game.SCORE_INCREASE
import com.example.android.unscramble.ui.game.allWordsList

class GameViewModel: ViewModel() {

    private var _score = 0
    private var _currentWordCount = 0
    private lateinit var _currentScrambledWord:String
    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    val currentScrambledWord: String get() = _currentScrambledWord
    val score:Int get()= _score
    val currentWordCount get() = _currentWordCount

    init{
        getNextWord()
    }

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)){
            tempWord.shuffle()
        }
        if(wordList.contains(currentWord)){
            getNextWord()
        }else{
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }
    private fun increaseScore(){
        _score += SCORE_INCREASE
    }
    fun isUserWordCorrect(playerWord : String): Boolean{
        if (playerWord.equals(currentWord,true)){
            increaseScore()
            return true
        }else{
            return false
        }
    }

    //  ViewModel 내의 데이터를 처리하고 수정하는 도우미미 메서
    fun nextWord(): Boolean{
        return if(_currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        }else false
    }

    fun reinitializeData(){
        _score = 0
        _currentWordCount=0
        wordList.clear()
        getNextWord()
    }

}