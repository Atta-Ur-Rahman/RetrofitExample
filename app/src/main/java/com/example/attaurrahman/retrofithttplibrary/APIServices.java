package com.example.attaurrahman.retrofithttplibrary;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIServices {
    @FormUrlEncoded
    @POST("signup/login")
    Call<LoginModel> userLogin(@Field("email") String email,
                               @Field("password") String password);
}
