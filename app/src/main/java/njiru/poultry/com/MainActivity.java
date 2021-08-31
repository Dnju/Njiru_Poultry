package njiru.poultry.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ChickenFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_Chicken);
        }
    }

    @SuppressLint("NonConstantResourceId")


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_Chicken:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChickenFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_Eggs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EggFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_meals:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MealFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_Vaccines:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new VaccineFragment()).commit();
                drawer.closeDrawers();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new homeFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);

        }
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {


        }
        super.onBackPressed();
    }
}