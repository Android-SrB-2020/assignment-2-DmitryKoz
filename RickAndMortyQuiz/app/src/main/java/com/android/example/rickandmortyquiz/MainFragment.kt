package com.android.example.rickandmortyquiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import com.android.example.rickandmortyquiz.databinding.FragmentMainBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.example.rickandmortyquiz.databinding.ActivityMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    private fun previousQuestion(){
        questionIndex = (questionIndex + 19) % 20
        questionView.setText(questionBank[questionIndex].index)
    }

    private fun nextQuestion(){
        questionIndex = (questionIndex + 1) % 20
        questionView.setText(questionBank[questionIndex].index)
    }

    private fun checkAnswer(){
        if(questionBank[questionIndex].answer == answer){
            Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "You are wrong, try again", Toast.LENGTH_SHORT).show()
        }
    }



    private var questionIndex = 0
    private lateinit var questionView: TextView
    private var answer : Boolean = false

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            navController = view.findNavController();



            questionView.setText(questionBank[questionIndex].index)
            binding.apply {


                binding.previousButton.setOnClickListener {
                    previousQuestion()
                }
                binding.nextButton.setOnClickListener {
                    nextQuestion()
                }
                binding.trueButton.setOnClickListener {
                    answer = true
                    checkAnswer()
                }
                binding.falseButton.setOnClickListener {
                    answer = false
                    checkAnswer()
                }

            }


        }












}
