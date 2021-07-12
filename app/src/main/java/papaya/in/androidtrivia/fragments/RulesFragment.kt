package papaya.`in`.androidtrivia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import papaya.`in`.androidtrivia.R
import papaya.`in`.androidtrivia.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRulesBinding>(inflater,
        R.layout.fragment_rules, container, false)

        return binding.root
    }

}