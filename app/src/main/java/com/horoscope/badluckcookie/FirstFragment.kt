package com.horoscope.badluckcookie

import android.content.res.Resources
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.horoscope.badluckcookie.databinding.FragmentFirstBinding
import java.lang.Math.random
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ibBadLuckCookie.setOnClickListener {

            sonidoGalleta()

            (activity as MainActivity).setFrase(getFraseRandom(R.array.malas_frases))

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.ibGoodLuckCookie.setOnClickListener {

            sonidoGalleta()

            (activity as MainActivity).setFrase(getFraseRandom(R.array.buenas_frases))

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun getFraseRandom(id:Int): String {

        var randomInt:Int
        randomInt = getRandomPosition(resources.getStringArray(id).size)

        return resources.getStringArray(id)[randomInt]
    }

    private fun getRandomPosition(max :Int): Int{
        val random = java.util.Random()
        return random.nextInt(max)
    }

    private fun sonidoGalleta(){
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.cookie_crack)
        mediaPlayer?.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


