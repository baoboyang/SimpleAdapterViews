package com.example.karlmorris.simpleadapterviews;

public class Item {
    String name, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String name, String description) {

        this.name = name;
        this.description = description;
    }
}
