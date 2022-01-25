package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String line;
    private String line2;
    private String city;

    protected Address() {
    }

    public Address(String line, String line2, String city) {
        this.line = line;
        this.line2 = line2;
        this.city = city;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
