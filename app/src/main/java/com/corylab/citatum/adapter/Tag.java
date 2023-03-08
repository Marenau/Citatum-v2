package com.corylab.citatum.adapter;

public class Tag {
    private String tag;

    public Tag() {
        this("tag");
    }
    public Tag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}