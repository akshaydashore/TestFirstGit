package com.example.demo.networkproject.bean;

/**
 * Created by akshaydashore on 9/4/18
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("slider")
    @Expose
    private List<Slider> slider = null;
    @SerializedName("popular_product")
    @Expose
    private List<PopularProduct> popularProduct = null;
    @SerializedName("popular_service")
    @Expose
    private List<PopularService> popularService = null;
    @SerializedName("popular_category")
    @Expose
    private List<PopularCategory> popularCategory = null;
    @SerializedName("all_category")
    @Expose
    private List<AllCategory> allCategory = null;

    public List<Slider> getSlider() {
        return slider;
    }

    public void setSlider(List<Slider> slider) {
        this.slider = slider;
    }

    public List<PopularProduct> getPopularProduct() {
        return popularProduct;
    }

    public void setPopularProduct(List<PopularProduct> popularProduct) {
        this.popularProduct = popularProduct;
    }

    public List<PopularService> getPopularService() {
        return popularService;
    }

    public void setPopularService(List<PopularService> popularService) {
        this.popularService = popularService;
    }

    public List<PopularCategory> getPopularCategory() {
        return popularCategory;
    }

    public void setPopularCategory(List<PopularCategory> popularCategory) {
        this.popularCategory = popularCategory;
    }

    public List<AllCategory> getAllCategory() {
        return allCategory;
    }

    public void setAllCategory(List<AllCategory> allCategory) {
        this.allCategory = allCategory;
    }

}
