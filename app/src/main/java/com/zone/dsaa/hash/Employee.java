package com.zone.dsaa.hash;

public class Employee {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private String name;
    private double salary;
    private int seniority;
}
