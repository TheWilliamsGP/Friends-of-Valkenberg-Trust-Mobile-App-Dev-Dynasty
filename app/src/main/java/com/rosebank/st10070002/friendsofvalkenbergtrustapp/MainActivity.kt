package com.rosebank.st10070002.friendsofvalkenbergtrustapp

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)   // ✅ MUST exist here

        loadFragment(HomeFragment())

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_about -> loadFragment(AboutFragment())
                R.id.nav_services -> loadFragment(ServicesFragment())
                R.id.nav_donate -> loadFragment(DonateFragment())
                R.id.nav_Volunteer -> loadFragment(VolunteerFragment())
                R.id.nav_resources -> loadFragment(ResourcesFragment())
                R.id.nav_events -> loadFragment(EventsFragment())
                R.id.nav_contact -> loadFragment(ContactFragment())
            }

            drawerLayout.closeDrawers()
            true
        }


        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open, R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}