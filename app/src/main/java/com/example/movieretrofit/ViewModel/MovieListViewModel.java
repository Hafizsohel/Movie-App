package com.example.movieretrofit.ViewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieretrofit.Service.Model.Result;
import com.example.movieretrofit.Service.Repository.MovieRepository;
import com.example.movieretrofit.Service.Repository.MovieRepositoryImpl;
import com.example.movieretrofit.View.UI.MainActivity;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepositoryImpl mRepo;


    public MovieListViewModel(@NonNull Application application) {
        super(application);

        mRepo= MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>> getTopRatedMovieList(){
        return mRepo.getTopRatedMovieList();
    }
}

