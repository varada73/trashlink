package com.example.trashlink;

public class model {
    String name, email,contact,city,details;

    public model() {
    }

    public model(String name,String email,String contact,String city,String details) {
        this.name = name;
        this.email=email;
        this.contact=contact;
        this.city=city;
        this.details=details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
