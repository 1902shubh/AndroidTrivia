package papaya.`in`.androidtrivia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import papaya.`in`.androidtrivia.R
import papaya.`in`.androidtrivia.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>
    )

    private val question: MutableList<Question> = mutableListOf(
        Question(
            text = "What is android Jetpack?",
            answers = listOf("All of these", "Tools", "Documentation", "Libraries")
        ),
        Question(
            text = "What is the base class for layouts?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "What layout do you use for complex screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "What do you use to push structured data into a layout?",
            answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")
        ),
        Question(
            text = "What method do you use to inflate layouts in fragments?",
            answers = listOf(
                "onCreateView()",
                "onActivityCreated()",
                "onCreateLayout()",
                "onInflateLayout()"
            )
        ),
        Question(
            text = "What's the build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Which class do you use to create a vector drawable?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"
            )
        ),
        Question(
            text = "Which one of these is an Android navigation component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Which XML element lets you register an activity with the launcher activity?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "What do you use to mark a layout for data binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestion = Math.min((question.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game, container, false
        )

        randomizeQuestions()
        binding.game = this

        binding.submitButton.setOnClickListener {
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != checkedId){
                var answerIndex = 0
                when(checkedId){
                    R.id.secondAnswerButton -> answerIndex = 1
                    R.id.thirdAnswerButton -> answerIndex = 2
                    R.id.fourthAnswerButton -> answerIndex = 3
                }
                if (answers[answerIndex] == currentQuestion.answers[0]){
                    questionIndex++

                    if (questionIndex < numQuestion){
                        currentQuestion = question[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    }
                    else
                        it.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
                }
                else it.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
            }
        }

        return binding.root
    }

    private fun randomizeQuestions() {
        question.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = question[questionIndex]
        answers = currentQuestion.answers.toMutableList()

        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestion)
    }

}