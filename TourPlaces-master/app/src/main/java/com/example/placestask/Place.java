package com.example.placestask;

public class Place {
    private String name;
    private int imageID;

    public Place(String name , int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName() {
        return name;
    }
    public int getimageID() {
        return imageID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setimageID(int imageID) {
        this.imageID = imageID;
    }
    }
