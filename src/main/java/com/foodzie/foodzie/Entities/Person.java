package com.foodzie.foodzie.Entities;

public class Person
{
    private int Id;
    private String name;
    private String email;
    private String address;
    private String dob;
    private int access;
    private String username;
    private String password;

    public Person()
    {

    }

    public Person(int id, String name, String email, String address, String dob, int access, String username, String password) {
        Id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.access = access;
        this.username = username;
        this.password = password;
    }




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
