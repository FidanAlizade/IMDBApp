package com.example.imdbapp.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.example.imdbapp.adapter.RecyclerViewAdapter;
import com.example.imdbapp.databinding.ActivityMainBinding;
import com.example.imdbapp.models.GetPopularMoviesModel;
import com.example.imdbapp.models.ResponseMovies;
import com.example.imdbapp.service.MovieAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<GetPopularMoviesModel> popularMoviesArraylList;
    final String BASE_URL= "https://api.themoviedb.org/3/" ;
    MovieAPI movieAPI;
    Retrofit retrofit;
    RecyclerViewAdapter recyclerViewAdapter;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);



            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            loadDataFromAPI();

        }

        private void loadDataFromAPI(){
            movieAPI = retrofit.create(MovieAPI.class);

            Call<ResponseMovies> call = movieAPI.getData();
            call.enqueue(new Callback<ResponseMovies>() {
                @Override
                public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                    if(response.isSuccessful()){
                        List<GetPopularMoviesModel> responseList = response.body().getResults();
                        //response  dan elde etdiyimiz listi bizim arrayliste qoyduq
                        popularMoviesArraylList = new ArrayList<>(responseList);
                        binding.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                        recyclerViewAdapter = new RecyclerViewAdapter(popularMoviesArraylList);
                        binding.recyclerView.setAdapter(recyclerViewAdapter);

                    }
                    recyclerViewAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<ResponseMovies> call, Throwable t) {

                }

            });

        }

}