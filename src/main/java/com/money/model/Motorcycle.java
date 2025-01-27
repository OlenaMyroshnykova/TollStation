package com.money.model;

class Motorcycle extends Vehicle {
    private static final double TOLL_FEE = 50.0;

    public Motorcycle(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double calculateToll() {
        return TOLL_FEE;
    }
}
