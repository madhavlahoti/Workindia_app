package com.example.workindiaapp;

public class Product {
    private String name;
    private String price;
    private String extra;
    private String coverImage;

    public  Product(){}
    public Product(String name,String price,String extra,String coverImage){
        this.name = name;
        this.price = price;
        this.coverImage = coverImage;
        this.extra = extra;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
