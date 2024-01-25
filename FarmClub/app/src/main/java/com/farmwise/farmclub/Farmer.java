package com.farmwise.farmclub;

// Farmer.java
public class Farmer {
    private long id;
    private String name;
    private String address;
    private String dob;
    private String gender;
    private String landArea;

    // Constructors, getters, and setters

    public Farmer(long id, String name, String address, String dob, String gender, String landArea) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.landArea = landArea;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getLandArea() {
        return landArea;
    }
}
