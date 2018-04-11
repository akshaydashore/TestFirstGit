package com.example.demo.networkproject.test;

/**
 * Created by akshaydashore on 11/4/18
 */


import android.content.Context;
import android.util.Log;

public class MainActivityRepresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private Context ctx;

    public MainActivityRepresenter(MainActivityContract.View view, Context ctx) {
        this.view = view;
        this.ctx = ctx;
    }

    @Override
    public void onShowData(TemperatureData temperatureData) {
        view.showData(temperatureData);
    }

    @Override
    public void showList() {
        Log.e("showList: ", "called");
    }

}