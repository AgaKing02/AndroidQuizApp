package com.example.quiz.services

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quiz.R
import com.example.quiz.models.Question
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.question_layout.view.*

class QuestionFragment : Fragment() {

    lateinit var currentView : View
    var question: Question? = null
    var answer: Int = -1


    override fun onStart() {
        super.onStart()

        activity?.next?.visibility = View.INVISIBLE

        currentView.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            val radioButton = radioGroup.findViewById<View>(i)
            answer = radioGroup.indexOfChild(radioButton)
            activity?.next?.visibility = View.VISIBLE
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        currentView = inflater.inflate(R.layout.question_layout,container,false);

        question = this.arguments?.getSerializable("Question") as Question?

        currentView.QuestionView.text = question?.question ?: ""
        currentView.radioA.text = question?.optiona ?: ""
        currentView.radioB.text = question?.optionb ?: ""


        return currentView
    }
}