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

    public Colections(Integer id, Integer urlImage,String name ,String price,String rating,Integer bigImageurl) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.urlImage = urlImage;
        this.rating = rating;
        this.bigImageurl= bigImageurl;
    }
    String rating;
    String name;
    String price;
    Integer id;
    int urlImage;
    int bigImageurl;

    public int getBigImageurl() {
        return bigImageurl;
    }

    public void setBigImageurl(int bigImageurl) {
        this.bigImageurl = bigImageurl;
    }



    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
