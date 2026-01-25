package dam.pmdm.rickandmortytarea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dam.pmdm.rickandmortytarea.data.model.Episode
import dam.pmdm.rickandmortytarea.databinding.FragmentEpisodesBinding
import kotlin.getValue

class EpisodesFragment : Fragment() {
    private lateinit var binding: FragmentEpisodesBinding
    private lateinit var adapter: EpisodeAdapter
    private val episodesViewModel: EpisodeViewModel by viewModels()
    private var allEpisodes: List<Episode> = emptyList()
    private val seenSet:MutableSet<String> = mutableSetOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // llamamos el RecyclerView
        adapter = EpisodeAdapter(emptyList()){episode->
            val bundle = Bundle().apply{
                putInt("episode_id", episode.id)
            }
            findNavController().navigate(R.id.episodeDetailFragment, bundle)
        }
        binding.rvEpisodes.adapter = adapter

        binding.rvEpisodes.layoutManager = LinearLayoutManager(requireContext())

        binding.tgFilter.check(R.id.btnAll)

        binding.tgFilter.addOnButtonCheckedListener { _, checkedId, isCheked ->
            if (isCheked)
            applyFilter(checkedId)
        }

        // observamos al ViewModel
        episodesViewModel.episodes.observe(viewLifecycleOwner) {list ->
            allEpisodes = list
            applyFilter(binding.tgFilter.checkedButtonId)
        }

        //cargamos los datos
        episodesViewModel.loadEpisodes()

    }

    // funcion para filtrar los episodios
    private fun applyFilter(checkedId:Int) {
        val filtered = when(checkedId){
            R.id.btnSeen -> allEpisodes.filter{seenSet.contains(it.episode)}
            R.id.btnAll, View.NO_ID -> allEpisodes
            else -> allEpisodes
        }
        adapter.updateList(filtered)
    }

}


