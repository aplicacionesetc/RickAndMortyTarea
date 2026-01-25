package dam.pmdm.rickandmortytarea

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.findFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import dam.pmdm.rickandmortytarea.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController
    private lateinit var toggle : ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener((binding.drawerLayout)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // Obtener el NavController desde el NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        // Configurar el icono del menú en la ActionBar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Configurar menu toogle (hamburguesa)
        configureToggleMenu();

        // Configurar la navegación
        configureNavigation();

    }

    private fun configureToggleMenu() {
        // Configurar el ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun configureNavigation() {
        // esto hace que al pulsar el menú se navegue al destino con el mismo id
        NavigationUI.setupWithNavController(binding.navView, navController)

        // Manejar la selección de elementos del menú
//        binding.navView.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_home -> {
//                    navController.navigate(R.id.EpisodesFragment) // Navegar al fragmento de inicio
//                }
//            }
//            binding.drawerLayout.closeDrawers() // Cerrar el menú
//            true
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Manejar clics en el icono del menú (permite que se gestione la hamburguesa)
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(
//            NavHostFragment.findNavController(binding.navView.findFragment()),
//            binding.drawerLayout
//        ) || super.onSupportNavigateUp()
//    }

}