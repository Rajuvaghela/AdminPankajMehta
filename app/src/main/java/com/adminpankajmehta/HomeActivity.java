package com.adminpankajmehta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.adminpankajmehta.Adapters.HomeAdapter2;
import com.adminpankajmehta.Adapters.HomeAdapterAudioComplaint;
import com.adminpankajmehta.Adapters.HomeAdapterTextComplaint;
import com.adminpankajmehta.Adapters.HomeAdapterVideoComplaint;
import com.adminpankajmehta.Api.ApiClient;
import com.adminpankajmehta.Api.ApiServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    HomeAdapter2 homeDataAdapter;
    HomeAdapterTextComplaint homeAdapterTextComplaint;
    HomeAdapterVideoComplaint homeAdapterVideoComplaint;
    HomeAdapterAudioComplaint homeAdapterAudioComplaint;

    RecyclerView recycler_view;
    private Button btnImageComplaint;
    private Button btnTextComplaint;
    private Button btnAudioComplaint;
    private Button btnVidoComplaint;
    List<String> homelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findviews();
    }

    @Override
    public void onClick(View v) {
        if (v == btnImageComplaint) {

            btnImageComplaint.setBackgroundColor(getResources().getColor(R.color.darkgrey));
            btnTextComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnAudioComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnVidoComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            homeDataAdapter = new HomeAdapter2(getApplicationContext(), homelist);
            recycler_view.setAdapter(homeDataAdapter);
            SetItemClickk();

        } else if (v == btnTextComplaint) {
            btnImageComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnTextComplaint.setBackgroundColor(getResources().getColor(R.color.darkgrey));
            btnAudioComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnVidoComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            homeAdapterTextComplaint = new HomeAdapterTextComplaint(getApplicationContext(), homelist);
            recycler_view.setAdapter(homeAdapterTextComplaint);
            SetItemClickktext();

        } else if (v == btnAudioComplaint) {

            btnImageComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnTextComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnAudioComplaint.setBackgroundColor(getResources().getColor(R.color.darkgrey));
            btnVidoComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            homeAdapterAudioComplaint = new HomeAdapterAudioComplaint(getApplicationContext(), homelist);
            recycler_view.setAdapter(homeAdapterAudioComplaint);
            SetItemClickAudio();

        } else if (v == btnVidoComplaint) {
            btnImageComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnTextComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnAudioComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnVidoComplaint.setBackgroundColor(getResources().getColor(R.color.darkgrey));


            homeAdapterVideoComplaint = new HomeAdapterVideoComplaint(getApplicationContext(), homelist);
            recycler_view.setAdapter(homeAdapterVideoComplaint);
            SetItemClickVideo();


        }
    }


    private void findviews() {

        btnImageComplaint = (Button) findViewById(R.id.btn_Image_complaint);
        btnTextComplaint = (Button) findViewById(R.id.btn_text_complaint);
        btnAudioComplaint = (Button) findViewById(R.id.btn_audio_complaint);
        btnVidoComplaint = (Button) findViewById(R.id.btn_vido_complaint);


        btnImageComplaint.setOnClickListener(this);
        btnTextComplaint.setOnClickListener(this);
        btnAudioComplaint.setOnClickListener(this);
        btnVidoComplaint.setOnClickListener(this);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(linearLayoutManager);

        homeDataAdapter = new HomeAdapter2(getApplicationContext(), homelist);
        recycler_view.setAdapter(homeDataAdapter);
        SetItemClickk();

        btnImageComplaint.setBackgroundColor(getResources().getColor(R.color.darkgrey));
        btnTextComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        btnAudioComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        btnVidoComplaint.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


        ApiCallImgComplaint();

    }

    private void ApiCallImgComplaint() {

        ApiServices apiService =
                ApiClient.getClient().create(ApiServices.class);

        Call<ResponseBody> call = apiService.homecomplaintdata("");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    Log.e("responsehome",response.body().string()+"");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    private void SetItemClickk() {
        homeDataAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), ComplaintDetailActivity.class);
                startActivity(intent);

            }
        });
    }

    private void SetItemClickVideo() {

        homeAdapterVideoComplaint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), ComplaintDetailActivity.class);
                startActivity(intent);

            }
        });

    }

    private void SetItemClickAudio() {

        homeAdapterAudioComplaint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), ComplaintDetailActivity.class);
                startActivity(intent);

            }
        });
    }

    private void SetItemClickktext() {

        homeAdapterTextComplaint.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), ComplaintDetailActivity.class);
                startActivity(intent);

            }
        });
    }


}
