package com.example.movieretrofit.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieretrofit.R;
import com.example.movieretrofit.Service.Model.Result;
import com.example.movieretrofit.View.Adapter.TopMovieListAdapter;
import com.example.movieretrofit.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private TopMovieListAdapter mMovieListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.RecID);

        GridLayoutManager LayoutManager= new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(LayoutManager);


        mViewModel= new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                mMovieListAdapter= new TopMovieListAdapter(MainActivity.this, results);
                recyclerView.setAdapter(mMovieListAdapter);

            }
        });

    }
}