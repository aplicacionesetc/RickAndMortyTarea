package dam.pmdm.rickandmortytarea

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dam.pmdm.rickandmortytarea.data.api.RetrofitInstance
import dam.pmdm.rickandmortytarea.databinding.FragmentEpisodeDetailBinding
import kotlinx.coroutines.launch


class EpisodeDetailFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeDetailBinding
    private lateinit var characterAdapter: CharacterAdapter

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

        // RecyclerView de los personajes
        characterAdapter = CharacterAdapter(emptyList())
        binding.rvCharacters.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCharacters.adapter = characterAdapter


        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val episode = RetrofitInstance.api.getEpisodeById(episodeId)
                binding.tvTitle.text = episode.name
                binding.tvCode.text = episode.episode
                binding.tvDate.text = episode.air_date

                val ids = extractCharacterIds(episode.characters)
                if (ids.isNotBlank()) {
                    val characters = RetrofitInstance.api.getCharactersById(ids)
                    characterAdapter.updateList(characters)
                }else{
                    Log.d("DETAIL", "IDs vacío, no cargo personajes")
                }
            }catch(e: Exception){
                android.util.Log.e("DETAIL", "Error cargando detalle", e)
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun extractCharacterIds(urls: List<String>): String {
        return urls.joinToString(",") { url ->
            url.substringAfterLast("/")
        }
    }

}