package com.example.imdbapp.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.imdbapp.R;
import com.example.imdbapp.databinding.RowLayoutBinding;
import com.example.imdbapp.models.GetPopularMoviesModel;
import com.example.imdbapp.views.DetailsActivity;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    public ArrayList<GetPopularMoviesModel> getPopularMoviesModelArrayList;

    public RecyclerViewAdapter(ArrayList<GetPopularMoviesModel> getPopularMoviesModelArrayList) {
        this.getPopularMoviesModelArrayList = getPopularMoviesModelArrayList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutBinding rowLayoutBinding = RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RowHolder(rowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.rowLayoutBinding.originalLanguage.setText(getPopularMoviesModelArrayList.get(position).getOriginal_language());
        holder.rowLayoutBinding.originalTitle.setText(getPopularMoviesModelArrayList.get(position).getOriginal_title());

        Glide.with(holder.itemView.getContext()).load(getPopularMoviesModelArrayList.get(position).getPoster_path()).fitCenter().placeholder(R.drawable.load)
                .into(holder.rowLayoutBinding.movieImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                    intent.putExtra("original_title", getPopularMoviesModelArrayList.get(position).getOriginal_title());
                    intent.putExtra("original_language", getPopularMoviesModelArrayList.get(position).getOriginal_language());
                    intent.putExtra("popularity", String.valueOf(getPopularMoviesModelArrayList.get(position).getPopularity()));
                    intent.putExtra("release_date", getPopularMoviesModelArrayList.get(position).getRelease_date());
                    intent.putExtra("genre_ids", String.valueOf(getPopularMoviesModelArrayList.get(position).getGenreIds()));
                    intent.putExtra("overview", getPopularMoviesModelArrayList.get(position).getOverview());
                    intent.putExtra("title", getPopularMoviesModelArrayList.get(position).getTitle());
                    intent.putExtra("id", String.valueOf(getPopularMoviesModelArrayList.get(position).getMovieId()));
                    intent.putExtra("poster_path", getPopularMoviesModelArrayList.get(position).getPoster_path());
                    intent.putExtra("backdrop_path", getPopularMoviesModelArrayList.get(position).getBackdrop_path());
                    intent.putExtra("vote_average",String.valueOf(getPopularMoviesModelArrayList.get(position).getVote_average()));
                    intent.putExtra("vote_count", String.valueOf(getPopularMoviesModelArrayList.get(position).getVote_count()));
                    intent.putExtra("adult", getPopularMoviesModelArrayList.get(position).getAdult());
                    intent.putExtra("video", getPopularMoviesModelArrayList.get(position).isVideo());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.itemView.getContext().startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return getPopularMoviesModelArrayList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{

        RowLayoutBinding rowLayoutBinding;
        public RowHolder(RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.rowLayoutBinding = rowLayoutBinding;
        }
    }
}