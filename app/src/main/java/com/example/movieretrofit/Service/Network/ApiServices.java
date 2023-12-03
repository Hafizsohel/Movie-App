package com.example.movieretrofit.Service.Network;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.movieretrofit.Service.Model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
@Dao
public interface ApiServices {

    @GET("3/movie/top_rated?api_key=0cf76fb6d0f22aa034ec06ca4a566464")
    Call<MovieModel>getTopRatedMovieLists();

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
   // void insert(List<MovieModel> getlist);


   // @Query("SELECT * FROM gets")
  //  List<MovieModel>getAllData();
//
   // @Query("DELETE FROM gets")
   // void deleteAll();
}
