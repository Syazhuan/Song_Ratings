package sg.edu.rp.c346.id22043300.songrating;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int star;

    public Song(int id, String title, String singers, int year, int star) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.star = star;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers;}

    public int getYear() { return year; }

    public int getStar() { return star; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStar(int star) {
        this.star = star;
    }
    @NonNull
    @Override
    public String toString() {
        return "No. " + id + "\n Song title: " + title + "\n Singers: " + singers + "\n Year: " + year + "\n Rating: " + star + " star(s)";

    }

}

