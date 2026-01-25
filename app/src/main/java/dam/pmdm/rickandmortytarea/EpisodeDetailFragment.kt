package dam.pmdm.rickandmortytarea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import dam.pmdm.rickandmortytarea.data.api.RetrofitInstance
import dam.pmdm.rickandmortytarea.databinding.FragmentEpisodeDetailBinding
import kotlinx.coroutines.launch


class EpisodeDetailFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEpisodeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val episodeId = requireArguments().getInt("episode_id")

        lifecycleScope.launch {
            val episode = RetrofitInstance.api.getEpisodeById(episodeId)
            binding.tvTitle.text = episode.name
            binding.tvCode.text = episode.episode
            binding.tvDate.text = episode.air_date
        }
    }

}