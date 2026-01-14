package com.examenpractic.Model;

public class Vehicle {
    public int id;
    public String licensePlate;
    public VehicleType type;
    public VehicleStatus status;
    public String ownerCity;

    public Vehicle() {
    }
    public Vehicle(int id, String licensePlate, VehicleType type, VehicleStatus status, String ownerCity) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.status = status;
        this.ownerCity = ownerCity;
    }
    public int getId() {
        return id;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public VehicleType getType() {
        return type;
    }
    public VehicleStatus getStatus() {
        return status;
    }
    public String getOwnerCity() {
        return ownerCity;
    }
    /*Ausgabeformat (Vehicle): 
    [#id] licensePlate | type | status | city=<ownerCity> */
    @Override
    public String toString() {
        return "[" + id + "] " + licensePlate + " | " + type + " | " + status + " | city=" + ownerCity;
    }
}
