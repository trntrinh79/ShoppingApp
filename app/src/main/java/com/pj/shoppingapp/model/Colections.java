package com.pj.shoppingapp.model;

public class Colections {

    String rating;
    String name;
    String price;
    Integer id;
    String urlImage;
    int bigImageurl;
    String description;
    String account;
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }







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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Colections(String account,Integer id, String urlImage, String name , String price, String rating, String description) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.urlImage = urlImage;
        this.rating = rating;
        this.description= description;
        this.account= account;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



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
