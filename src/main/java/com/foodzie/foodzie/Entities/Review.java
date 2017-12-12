package com.foodzie.foodzie.Entities;

import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "review")
public class Review {

    private Long Id;
    private Double rating;
    private String comment;
    private Person person;
    private Outlet outlet;

    @OneToOne(cascade = CascadeType.ALL)
    @Cascade(value = {org.hibernate.annotations.CascadeType.DELETE})
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @Cascade(value = {org.hibernate.annotations.CascadeType.DELETE})
    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public Review() {

    }

    public Review(Review other) {
        if (other != null) {
            this.Id = other.Id;
            this.rating = other.rating;
            this.comment = other.comment;
            this.person = new Person(other.person);
            this.outlet = new Outlet(other.outlet);
        }
    }

    public Review(Long id, Double rating, String comment) {
        Id = id;
        this.rating = rating;
        this.comment = comment;
    }

    @Column
    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Column
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static final class Builder {

        private Review review;

        public Builder() {
            this(new Review());
        }

        public Builder(Review review) {
            this.review = new Review(review);
        }

        public Builder id(long id) {
            this.review.setId(id);
            return this;
        }

        public Builder comment(String comment) {
            this.review.setComment(comment);
            return this;
        }

        public Builder rating(double rating) {
            this.review.setRating(rating);
            return this;
        }

        public Builder outlet(Outlet outlet) {
            this.review.setOutlet(outlet);
            return this;
        }

        public Builder person(Person person)  {
            this.review.setPerson(person);
            return this;
        }

        public Review build() {
            return this.review;
        }

    }

}