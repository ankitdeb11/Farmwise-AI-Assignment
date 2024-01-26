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

    private String imagePath1;
    private String imagePath2;
    private String videoPath;

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

    public Farmer(int id, String name, String address, String dob,
                  String gender, String landArea, double latitude, double longitude,
                  String imagePath1, String imagePath2, String videoPath) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.landArea = landArea;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagePath1 = imagePath1;
        this.imagePath2 = imagePath2;
        this.videoPath = videoPath;
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



    //getters and setters for thirs try path

    public String getImagePath1() {
        return imagePath1;
    }

    public void setImagePath1(String imagePath1) {
        this.imagePath1 = imagePath1;
    }

    public String getImagePath2() {
        return imagePath2;
    }

    public void setImagePath2(String imagePath2) {
        this.imagePath2 = imagePath2;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }



}