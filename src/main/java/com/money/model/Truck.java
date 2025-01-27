package com.money.model;

class Truck extends Vehicle {
    private static final double TOLL_PER_AXLE = 50.0;
    private int axles;

    public Truck(String licensePlate, int axles) {
        super(licensePlate);
        this.axles = axles;
    }

    @Override
    public double calculateToll() {
        return axles * TOLL_PER_AXLE;
    }
}
