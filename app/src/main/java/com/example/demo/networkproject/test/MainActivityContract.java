package com.example.demo.networkproject.test;

/**
 * Created by akshaydashore on 11/4/18
 */

public interface MainActivityContract {
    public interface Presenter {
        void onShowData(TemperatureData temperatureData);
        void showList();
    }

    public interface View {
        void showData(TemperatureData temperatureData);
    }

}
