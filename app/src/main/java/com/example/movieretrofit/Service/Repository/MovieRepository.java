package com.example.movieretrofit.Service.Repository;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.example.movieretrofit.Service.Model.MovieModel;
import com.example.movieretrofit.Service.Model.Result;
import com.example.movieretrofit.Service.Network.ApiServices;
import com.example.movieretrofit.Service.Network.RetrofitInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository implements MovieRepositoryImpl {


    private static Context mcontext;
    private MovieModel movieModel;
    private static MovieRepository instance;
    private List<Result> mResult;
    private MutableLiveData mLiveData;
    private static List<MovieModel> getAllMovies;


    public static MovieRepository getInstance(Context context) {
        if (instance == null) {
            mcontext = context;
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList(){

        if (mLiveData == null) {
            mLiveData = new MutableLiveData();
        }

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<MovieModel> call = apiServices.getTopRatedMovieLists();

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel = response.body();
                mResult = movieModel.getResults();

                mLiveData.postValue(mResult);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
        return mLiveData;
    }

}
