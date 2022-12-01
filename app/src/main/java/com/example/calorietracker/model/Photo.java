package com.example.calorietracker.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "Photo_table")
public class Photo {
  //  @PrimaryKey(autoGenerate = true)
    private int id;
    private String thumb;
    private String highres;

    public Photo(String thumb, String highres) {
        this.thumb = thumb;
        this.highres = highres;
    }

    public Photo(int id, String thumb, String highres) {
        this.id = id;
        this.thumb = thumb;
        this.highres = highres;
    }

    public Photo() {
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getHighres() {
        return highres;
    }

    public void setHighres(String highres) {
        this.highres = highres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "thumb='" + thumb + '\'' +
                ", highres='" + highres + '\'' +
                '}';
    }
}
