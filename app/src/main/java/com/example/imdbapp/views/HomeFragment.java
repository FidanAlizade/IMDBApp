package com.example.imdbapp.views;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imdbapp.R;
import com.example.imdbapp.adapter.RecyclerViewAdapter;
import com.example.imdbapp.databinding.FragmentHomeBinding;
import com.example.imdbapp.models.GetPopularMoviesModel;
import com.example.imdbapp.models.ResponseMovies;
import com.example.imdbapp.service.MovieAPI;
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

public class HomeFragment extends Fragment {
    ArrayList<GetPopularMoviesModel> popularMoviesArraylList;
    final String BASE_URL= "https://api.themoviedb.org/3/" ;
    MovieAPI movieAPI;
    Retrofit retrofit;
    RecyclerViewAdapter recyclerViewAdapter;

    private FragmentHomeBinding binding;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        loadDataFromAPI();
        return root;
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
                    Collections.sort(responseList, GetPopularMoviesModel.BY_NAME_ALPHABETICAL);
                    popularMoviesArraylList = new ArrayList<>(responseList);
                    binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
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