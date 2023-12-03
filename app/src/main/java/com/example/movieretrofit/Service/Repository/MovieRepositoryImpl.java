package com.example.movieretrofit.Service.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.movieretrofit.Service.Model.Result;

import java.util.List;

public interface MovieRepositoryImpl {
    public MutableLiveData<List<Result>> getTopRatedMovieList();
}
