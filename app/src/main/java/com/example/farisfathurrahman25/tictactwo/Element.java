package com.example.farisfathurrahman25.tictactwo;

public class Element {
    private int imageId;
    private String name;
    private String description;


    public Element(int imageId, String name, String description) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescript(String description) {
        this.description = description;
    }
}