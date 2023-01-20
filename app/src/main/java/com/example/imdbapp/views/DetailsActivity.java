package com.example.imdbapp.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.imdbapp.R;

public class DetailsActivity extends AppCompatActivity {
ImageView image;
TextView originalTitle1, title1, overview1, popularity1, voteCount1, voteAverage1, releaseDate1;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);

        image = findViewById(R.id.imageViewOverview);
        title1 = findViewById(R.id.titleText);
        originalTitle1 = findViewById(R.id.orginalTitle);
        overview1 = findViewById(R.id.overview);
        popularity1 = findViewById(R.id.popularity);
        voteCount1 = findViewById(R.id.vote_count);
        voteAverage1 = findViewById(R.id.vote_average);
        releaseDate1 = findViewById(R.id.release_date);

        Intent intent = getIntent();
        try {
            if(intent.hasExtra("original_title")){
                String imageView  = intent.getExtras().getString("poster_path");
                String textTitle  = intent.getExtras().getString("title");
                String originalTitle  = intent.getExtras().getString("original_title");
                String overview  = intent.getExtras().getString("overview");
                String popularity  = intent.getExtras().getString("popularity");
                String vote_count  = intent.getExtras().getString("vote_count");
                String vote_average  = intent.getExtras().getString("vote_average");
                String release_date  = intent.getExtras().getString("release_date");

                Glide.with(this).load(imageView).placeholder(R.drawable.load).centerCrop().into(image);

                title1.setText(textTitle);
                originalTitle1.setText(originalTitle);
                overview1.setText(overview);
                popularity1.setText(popularity);
                voteCount1.setText(vote_count);
                voteAverage1.setText(vote_average);
                releaseDate1.setText(release_date);


            }
        }catch (Exception e){
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
