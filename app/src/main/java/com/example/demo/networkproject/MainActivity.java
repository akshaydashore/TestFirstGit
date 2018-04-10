package com.example.demo.networkproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.demo.networkproject.bean.HomeBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private HomeBean homeBean;
    private RecyclerView recycler_view;
    private android.content.Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        Task task = new Task();
        task.execute();
        initView();

    }

    private void initView() {

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        recycler_view.setLayoutManager(manager);
    }

    private void setAdapter() {

        HomeAdapter homeAdapter = new HomeAdapter(context, homeBean);
        recycler_view.setAdapter(homeAdapter);
    }


    class Task extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            try {

                URL url = new URL(MyApplication.url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("GET");
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();
                String l = "";
                while ((l = reader.readLine()) != null) {
                    builder.append(l);
                }

                return builder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("onPostExecute: ", s);
            Gson gson = new Gson();
            homeBean = gson.fromJson(s, HomeBean.class);
            setAdapter();
        }

    }

}
