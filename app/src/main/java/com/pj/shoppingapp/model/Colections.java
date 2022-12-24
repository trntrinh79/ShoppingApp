package com.pj.shoppingapp.model;

public class Colections {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Integer urlImage) {
        this.urlImage = urlImage;
    }

    public Colections(Integer id, Integer urlImage,String name ,String price) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.urlImage = urlImage;
    }

    String name;
    String price;
    Integer id;
    int urlImage;
}
