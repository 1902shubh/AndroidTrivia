package papaya.`in`.androidtrivia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import papaya.`in`.androidtrivia.R
import papaya.`in`.androidtrivia.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameWonBinding>(inflater,
        R.layout.fragment_game_won, container, false)

        binding.winDone.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }

        return binding.root
    }

}