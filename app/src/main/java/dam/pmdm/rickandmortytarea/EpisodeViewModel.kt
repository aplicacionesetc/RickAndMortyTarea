package dam.pmdm.rickandmortytarea

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dam.pmdm.rickandmortytarea.data.api.RetrofitInstance
import dam.pmdm.rickandmortytarea.data.model.Episode
import kotlinx.coroutines.launch

class EpisodeViewModel: ViewModel() {
    private val _episodes = MutableLiveData<List<Episode>>()
    val episodes: LiveData<List<Episode>> = _episodes

    fun loadEpisodes(){
        viewModelScope.launch {
            try{
                _episodes.value = RetrofitInstance.api.getEpisodes().results
            }catch(e: Exception){
                _episodes.value = emptyList()
            }
        }
    }

}