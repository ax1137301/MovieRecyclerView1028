package com.example.MovieRecyclerView1028;

public class Movie {
    public int img;
    public String name;
    public String date;
    public String plot;

    public Movie(int img, String name, String date, String plot) {
        this.img = img;
        this.name = name;
        this.date = date;
        this.plot = plot;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
