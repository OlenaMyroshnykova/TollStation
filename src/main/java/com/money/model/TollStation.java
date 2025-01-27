package com.money.model;

import java.util.ArrayList;
import java.util.List;

class TollStation {
    private String name;
    private String city;
    private double totalCollected;
    private List<Vehicle> vehicles;

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalCollected = 0;
        this.vehicles = new ArrayList<>();
    }

    public void registerVehicle(Vehicle vehicle) {
        double toll = vehicle.calculateToll();
        totalCollected += toll;
        vehicles.add(vehicle);
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " paid: $" + toll);
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void printSummary() {
        System.out.println("Toll Station: " + name + " in " + city);
        System.out.println("Total collected: $" + totalCollected);
        System.out.println("Vehicles passed:");
        for (Vehicle vehicle : vehicles) {
            System.out.println("- " + vehicle.getLicensePlate());
        }
    }
}
