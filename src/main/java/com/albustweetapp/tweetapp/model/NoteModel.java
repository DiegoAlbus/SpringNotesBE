package com.albustweetapp.tweetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity // Map to DB configured
public class NoteModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) // Can never be null or updated on DB
    private Long id;
    private String title;
    private String description;
    private String imageURL;
    private Date date;

    public NoteModel() {
    }

    public NoteModel(String title, String description, String imageURL, Date date) {
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
