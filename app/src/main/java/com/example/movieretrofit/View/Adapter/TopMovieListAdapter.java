package com.example.movieretrofit.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieretrofit.R;
import com.example.movieretrofit.Service.Model.Result;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder> {


   private Context mcontext;
   private List<Result>mList;

    public TopMovieListAdapter(Context mcontext, List<Result> mList) {
        this.mcontext = mcontext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //We doing view
        View view=LayoutInflater.from(mcontext).inflate(R.layout.movie_single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitle.setText(mList.get(position).getTitle());
        holder.mRating.setText(mList.get(position).getVoteAverage().toString());


        holder.mReleaseDate.setText(mList.get(position).getReleaseDate());
    //https://image.tmdb.org/t/p/w500/6gIJuFHh5Lj4dNaPG3TzIMl7L68.jpg

        Glide.with(mcontext).load("https://image.tmdb.org/t/p/w500/" +mList.get(position).getPosterPath())
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {

        if (this.mList!=null){
            return mList.size();
        }
        else
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitle, mRating, mReleaseDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //I will get everything designed by XML via ItemView.

            mTitle= itemView.findViewById(R.id.titleID);
            mRating= itemView.findViewById(R.id.ratingID);
            mReleaseDate= itemView.findViewById(R.id.releaseID);
            mImageView=itemView.findViewById(R.id.IMView);

        }
    }

}
