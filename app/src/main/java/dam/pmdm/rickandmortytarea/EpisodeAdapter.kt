package dam.pmdm.rickandmortytarea

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.rickandmortytarea.data.model.Episode
import dam.pmdm.rickandmortytarea.databinding.ItemEpisodeBinding

class EpisodeAdapter(private var episodes : List<Episode>, private val onClick:(Episode)-> Unit): RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    fun updateList(newList: List<Episode>) {
        episodes = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpisodeViewHolder {
        val binding = ItemEpisodeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: EpisodeViewHolder,
        position: Int
    ) {
        holder.bind(episodes[position])
    }

    override fun getItemCount(): Int = episodes.size


    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(episode: Episode){
            binding.tvName.text = episode.name
            binding.tvCode.text = episode.episode
            binding.tvDate.text = episode.air_date

            // verificamos el id del episodio para ver si ha sido visto
            val isSeen = SeenPrefs.isSeen(binding.root.context, episode.id)
            // si es así, oscurecemos el episodio como "visto"
            binding.root.alpha = if (isSeen) 0.5f else 1.0f


            // hacer click en cada episodio indivualmente
            binding.root.setOnClickListener {
                onClick(episode)
            }
        }
    }
}

