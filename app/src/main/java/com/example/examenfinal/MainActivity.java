package com.example.examenfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;
import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        MutableLiveData<List<MoveListItem>> moveList = new MutableLiveData<>();
        PokeAPI.getMoveList(moveList);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_movements:
                        navController.navigate(R.id.moveListRecyclerFragment);
                        break;
                    case R.id.menu_items:
                        navController.navigate(R.id.itemListRecyclerFragment);
                        break;
                    case R.id.menu_random_item:
                        // Navega a un ítem aleatorio
                        break;
                    default:
                        return false;
                }
                drawerLayout.closeDrawers(); // Cierra el menú deslizante después de seleccionar un elemento
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        navController = Navigation.findNavController(this, R.id.fragment);
    }

    //menu barra de opciones
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.menu_movements:
                navController.navigate(R.id.moveListRecyclerFragment);
                break;
            case R.id.menu_items:
                navController.navigate(R.id.itemListRecyclerFragment);
                break;
            case R.id.menu_random_item:
                // Navega a un ítem aleatorio
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


}