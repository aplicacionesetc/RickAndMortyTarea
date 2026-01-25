package dam.pmdm.rickandmortytarea.data.api

import dam.pmdm.rickandmortytarea.data.model.Episode
import dam.pmdm.rickandmortytarea.data.model.EpisodesApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("episode")
    suspend fun getEpisodes(): EpisodesApiResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id")id:Int): Episode
}