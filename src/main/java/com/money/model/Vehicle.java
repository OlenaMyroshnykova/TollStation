package com.money.model;

abstract class Vehicle {
    protected String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public abstract double calculateToll();

    public String getLicensePlate() {
        return licensePlate;
    }
}
