package com.app.logintest.Retrofit;


import com.app.logintest.Model.Login;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    String CACHE = "Cache-Control: max-age=0";
    String AGENT = "Data-Agent: MvvmApp";



    @FormUrlEncoded
    @POST("login")
    Call<Login> login(@Field("email") String email,
                      @Field("password") String password);
}
