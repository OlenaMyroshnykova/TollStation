package com.money.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TollStationTest {

    @Test
    void testCarToll() {
        Vehicle car = new Car("ABC-123");
        assertEquals(100.0, car.calculateToll());
    }

    @Test
    void testMotorcycleToll() {
        Vehicle motorcycle = new Motorcycle("XYZ-789");
        assertEquals(50.0, motorcycle.calculateToll());
    }

    @Test
    void testTruckToll() {
        Vehicle truck = new Truck("LMN-456", 4);
        assertEquals(200.0, truck.calculateToll());
    }

    @Test
    void testTollStationTotalCollected() {
        TollStation station = new TollStation("Main Toll", "New York");
        station.registerVehicle(new Car("ABC-123"));
        station.registerVehicle(new Motorcycle("XYZ-789"));
        station.registerVehicle(new Truck("LMN-456", 3));

        assertEquals(100 + 50 + 150, station.getTotalCollected());
    }

    @Test
    void testGetVehicles() {
        TollStation station = new TollStation("Main Toll", "New York");
        Vehicle car = new Car("ABC-123");
        Vehicle motorcycle = new Motorcycle("XYZ-789");
        station.registerVehicle(car);
        station.registerVehicle(motorcycle);
        
        List<Vehicle> vehicles = station.getVehicles();
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(car));
        assertTrue(vehicles.contains(motorcycle));
    }

    @Test
    void testPrintSummary() {
        TollStation station = new TollStation("Main Toll", "New York");
        Vehicle car = new Car("ABC-123");
        Vehicle motorcycle = new Motorcycle("XYZ-789");
        station.registerVehicle(car);
        station.registerVehicle(motorcycle);

        // Redirect output for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        station.printSummary();

        String output = outputStream.toString();
        assertTrue(output.contains("Toll Station: Main Toll in New York"));
        assertTrue(output.contains("Total collected: $150.0"));
        assertTrue(output.contains("- ABC-123"));
        assertTrue(output.contains("- XYZ-789"));

        // Reset System.out
        System.setOut(System.out);
    }
}
    
