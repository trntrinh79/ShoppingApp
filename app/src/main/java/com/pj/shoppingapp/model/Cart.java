package com.pj.shoppingapp.model;

public class Cart {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Cart(String name, String price, String imageUrl, String size) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.size = size;
    }
    String size;
    String name;
    String price;
    String imageUrl;
}
