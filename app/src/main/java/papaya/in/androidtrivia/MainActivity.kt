package papaya.`in`.androidtrivia

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import papaya.`in`.androidtrivia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        NavigationUI.setupWithNavController(binding.navView, navController)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_us -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                navController.navigate(R.id.action_titleFragment2_to_aboutFragment)
            }
            R.id.rules -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                navController.navigate(R.id.action_titleFragment2_to_rulesFragment)
            }
        }
        return NavigationUI.onNavDestinationSelected(item, navController)
    }
}