package com.foodzie.foodzie.Entities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name = "outlet")
public class Outlet {


    private Long id;


    private String name;
    private String address;
    private String cuisine;
    private Double rating;
    private int numOfUsersRated;
    private int numOfCriticsRated;

    public Outlet() {
    }

    public Outlet(Outlet other) {
        if (other != null) {
            this.id = other.id;
            this.name = other.name;
            this.address = other.address;
            this.cuisine = other.cuisine;
            this.rating = other.rating;
            this.numOfUsersRated = other.numOfUsersRated;
            this.numOfCriticsRated = other.numOfCriticsRated;
        }
    }

    public Outlet(Long id, String name, String address, String cuisine, Double rating, int numOfUsersRated, int numOfCriticsRated, Person owner) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.rating = rating;
        this.numOfUsersRated = numOfUsersRated;
        this.numOfCriticsRated = numOfCriticsRated;

    }

    @Column(unique = true)
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Formula("(select sum(r.rating) / count(r.person_id) from outlet o join review r on r.outlet_id = o.id group by o.id having o.id = id)")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Formula("(select count(1) from outlet o join review r on r.outlet_id = o.id)")
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


}
