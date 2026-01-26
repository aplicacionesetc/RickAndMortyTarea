package dam.pmdm.rickandmortytarea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dam.pmdm.rickandmortytarea.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {
    private lateinit var binding: FragmentStatsBinding
    private val viewModel: EpisodeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.episodes.observe(viewLifecycleOwner){ episodes ->
            val total = episodes.size
            val seenSet = SeenPrefs.getSeenSet(requireContext())
            val seenCount = episodes.count { seenSet.contains(it.id.toString()) }

            val percent = if (total == 0) 0 else(seenCount * 100 / total)

            binding.tvTotal.text= "Total episodios: $total"
            binding.tvSeen.text = "Vistos: $seenCount"
            binding.tvPercent.text = "Progreso: $percent%"
            binding.progress.progress = percent

        }
        viewModel.loadEpisodes()
    }

}