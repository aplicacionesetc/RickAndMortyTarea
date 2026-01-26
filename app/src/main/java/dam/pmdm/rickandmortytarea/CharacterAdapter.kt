package dam.pmdm.rickandmortytarea

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dam.pmdm.rickandmortytarea.data.model.Character
import dam.pmdm.rickandmortytarea.databinding.ItemCharacterBinding

class CharacterAdapter(private var characters:List<Character>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    fun updateList(newList: List<Character>) {
        characters = newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val binding = ItemCharacterBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CharacterViewHolder,
        position: Int
    ) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size


    inner class CharacterViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){
            binding.tvCharacterName.text = character.name
            binding.ivCharacter.load(character.image)
        }
    }
}