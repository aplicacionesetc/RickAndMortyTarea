package dam.pmdm.rickandmortytarea.data.model

data class Episode(
    val id:Int,
    val name: String,
    val episode:String,
    val air_date:String,
    val characters:List<String>
)

data class EpisodesApiResponse(
    val results: List<Episode>
)
