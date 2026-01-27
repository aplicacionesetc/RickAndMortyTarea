package dam.pmdm.rickandmortytarea

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dam.pmdm.rickandmortytarea.databinding.DialogAboutBinding

class AboutDialog : DialogFragment() {
    private lateinit var binding: DialogAboutBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogAboutBinding.inflate(requireActivity().layoutInflater)

        binding.tvDeveloper.text = getString(R.string.aboutDialogDeveloper)
        binding.tvVersion.text = getString(R.string.aboutDialogVersion)

        // funcionalidad de botón de cerrar
        binding.btnClose.setOnClickListener {
            dismiss()
        }

        return MaterialAlertDialogBuilder(requireContext())
            .setView(binding.root)
            .create()
    }
}