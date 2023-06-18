package com.kenkorcak.recordkeeperv3.cycling

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kenkorcak.recordkeeperv3.databinding.FragmentCyclingBinding
import com.kenkorcak.recordkeeperv3.running.EditCyclingRecordActivity

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setUpClickListeners() {
        binding.containerBiggestClimb.setOnClickListener { launchCyclingRecordScreen("Biggest Climb") }
        binding.containerBestAverageSpeed.setOnClickListener { launchCyclingRecordScreen("Best Average Speed") }
        binding.containerLongestRide.setOnClickListener { launchCyclingRecordScreen("Longest Ride") }
    }

    private fun displayRecords() {
        val cyclingPreferences =
            requireContext().getSharedPreferences("record", Context.MODE_PRIVATE)

        binding.textViewBestAverageSpeed.text =
            cyclingPreferences.getString("Best Average Speed", null)
        binding.textViewBestAverageSpeedDate.text =
            cyclingPreferences.getString("Best Average Speed Date", null)
        binding.textViewBiggestClimbValue.text = cyclingPreferences.getString("Biggest Climb", null)
        binding.textViewBiggestClimbDate.text =
            cyclingPreferences.getString("Biggest Climb Date", null)
        binding.textViewLongestRideValue.text = cyclingPreferences.getString("Longest Ride", null)
        binding.textViewLongestRideDate.text =
            cyclingPreferences.getString("Longest Ride Date", null)
    }

    private fun launchCyclingRecordScreen(type: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Type", type)
        startActivity(intent)
    }
}