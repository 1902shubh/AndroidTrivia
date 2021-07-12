package papaya.`in`.androidtrivia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import papaya.`in`.androidtrivia.R
import papaya.`in`.androidtrivia.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater,
        R.layout.fragment_game_over, container, false)

        binding.tryAgain.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }
        return binding.root
    }

}