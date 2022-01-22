package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

public class PartTimeEmployee extends Employee {
    private BigDecimal hourlyWages;

    protected PartTimeEmployee() {

    }

    public PartTimeEmployee(String name, BigDecimal hourlyWages) {
        super(name);
        this.hourlyWages = hourlyWages;
    }

}
