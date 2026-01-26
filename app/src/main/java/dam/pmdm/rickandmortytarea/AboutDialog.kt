package dam.pmdm.rickandmortytarea

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AboutDialog : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val versionName = requireContext()
            .packageManager
            .getPackageInfo(requireContext().packageName, 0)
            .versionName

        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Acerca de")
            .setMessage("Desarrollador: Alejandro Tinedo Requesens\nVersión: $versionName")
            .setPositiveButton("OK", null)
            .create()
    }
}