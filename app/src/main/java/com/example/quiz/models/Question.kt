package com.example.quiz.models

import java.io.Serializable

class Question(
    id: Int,
    question: String,
    optiona: String,
    optionb: String,
    answer: Int
) : Serializable {
    var id = id
    var question = question
    var optiona = optiona
    var optionb = optionb
    var answer = answer
}
