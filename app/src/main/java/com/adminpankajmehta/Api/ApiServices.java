package com.adminpankajmehta.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by raju on 09-09-2017.
 */

public interface ApiServices
{
    @FormUrlEncoded
    @GET("users/{user}/repos")
    Call<ResponseBody> homecomplaintdata(@Field("user") String user);
}
