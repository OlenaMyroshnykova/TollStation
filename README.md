# TollStation
```mermaid
classDiagram
    class Vehicle {
        <<abstract>>
        - String licensePlate
        + Vehicle(String licensePlate)
        + double calculateToll()
        + String getLicensePlate()
    }

    class Car {
        - static final double TOLL_FEE = 100.0
        + Car(String licensePlate)
        + double calculateToll()
    }

    class Motorcycle {
        - static final double TOLL_FEE = 50.0
        + Motorcycle(String licensePlate)
        + double calculateToll()
    }

    class Truck {
        - static final double TOLL_PER_AXLE = 50.0
        - int axles
        + Truck(String licensePlate, int axles)
        + double calculateToll()
    }

    class TollStation {
        - String name
        - String city
        - double totalCollected
        - List~Vehicle~ vehicles
        + TollStation(String name, String city)
        + void registerVehicle(Vehicle vehicle)
        + double getTotalCollected()
        + List~Vehicle~ getVehicles()
        + void printSummary()
    }

    Vehicle <|-- Car
    Vehicle <|-- Motorcycle
    Vehicle <|-- Truck
    TollStation --> "*" Vehicle : manages
