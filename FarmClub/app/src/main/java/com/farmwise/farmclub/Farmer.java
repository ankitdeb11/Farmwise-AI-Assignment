package com.farmwise.farmclub;

// Farmer.java
public class Farmer {
    private int id;
    private String name;
    private String address;
    private String dob;
    private String gender;
    private String landArea;

    // New members for latitude and longitude
    private double latitude;
    private double longitude;

    // Constructors, getters, and setters

    // Getter for latitude
    public double getLatitude() {
        return latitude;
    }

    // Setter for latitude
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getter for longitude
    public double getLongitude() {
        return longitude;
    }

    // Setter for longitude
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Farmer(int id, String name, String address, String dob, String gender, String landArea, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.landArea = landArea;
        this.latitude = latitude;
        this.longitude = longitude;
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