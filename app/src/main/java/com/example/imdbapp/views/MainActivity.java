package com.example.imdbapp.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.imdbapp.R;
import com.example.imdbapp.adapter.RecyclerViewAdapter;
import com.example.imdbapp.databinding.ActivityMainBinding;
import com.example.imdbapp.models.GetPopularMoviesModel;
import com.example.imdbapp.models.ResponseMovies;
import com.example.imdbapp.service.MovieAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);

            getSupportFragmentManager().beginTransaction().replace(R.id.body_layout,new HomeFragment()).commit();
            binding.bottomNavigationBar.setSelectedItemId(R.id.nav_home);
            binding.bottomNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Fragment fragment =  null;
                   switch (item.getItemId()){
                       case R.id.nav_home:
                           fragment = new HomeFragment();
                           break;
                       case R.id.nav_fav:
                           fragment = new FavoritesFragment();
                           break;
                       case R.id.nav_searches:
                           fragment = new SearchesFragment();
                           break;
                   }
                   getSupportFragmentManager().beginTransaction().replace(R.id.body_layout,fragment).commit();
                   return true;
               }
            });
        }
}