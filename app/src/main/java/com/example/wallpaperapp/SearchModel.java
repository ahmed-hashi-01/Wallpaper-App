package com.example.wallpaperapp;

import java.util.ArrayList;

public class SearchModel {
    public ArrayList<Imagemodel> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Imagemodel> photos) {
        this.photos = photos;
    }

    public SearchModel(ArrayList<Imagemodel> photos) {
        this.photos = photos;
    }

    private ArrayList<Imagemodel> photos ;
}
