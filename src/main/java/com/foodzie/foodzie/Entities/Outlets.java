package com.foodzie.foodzie.Entities;


public class Outlets {

    private Long Id;
    private String name;
    private String address;
    private String cuisine;
    private Double rating;
    private int numOfUsersRated;
    private int numOfCriticsRated;
    private Person owner;

    public Outlets() {
    }

    public Outlets(Long id, String name, String address, String cuisine, Double rating, int numOfUsersRated, int numOfCriticsRated, Person owner) {
        this.Id = id;
        this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.rating = rating;
        this.numOfUsersRated = numOfUsersRated;
        this.numOfCriticsRated = numOfCriticsRated;
        this.owner = owner;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getNumOfUsersRated() {
        return numOfUsersRated;
    }

    public void setNumOfUsersRated(int numOfUsersRated) {
        this.numOfUsersRated = numOfUsersRated;
    }

    public int getNumOfCriticsRated() {
        return numOfCriticsRated;
    }

    public void setNumOfCriticsRated(int numOfCriticsRated) {
        this.numOfCriticsRated = numOfCriticsRated;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
