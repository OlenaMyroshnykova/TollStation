package com.money.model;

class Car extends Vehicle {
    private static final double TOLL_FEE = 100.0;

    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double calculateToll() {
        return TOLL_FEE;
    }
}