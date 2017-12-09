package com.foodzie.foodzie.Entities;

public class Reviews {

    private Long Id;
    private Double rating;
    private String comment;
    private Outlets outlet;
    private Person reviewer;

    public Reviews() {
    }

    public Reviews(Long id, Double rating, String comment, Outlets outlet, Person reviewer) {
        Id = id;
        this.rating = rating;
        this.comment = comment;
        this.outlet = outlet;
        this.reviewer = reviewer;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Outlets getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlets outlet) {
        this.outlet = outlet;
    }

    public Person getReviewer() {
        return reviewer;
    }

    public void setReviewer(Person reviewer) {
        this.reviewer = reviewer;
    }
}
