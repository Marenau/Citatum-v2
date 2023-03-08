package com.corylab.citatum.adapter;

public class Title {
    private String title, author;

    public Title() {
        this("No title", "No author");
    }
    public Title(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}