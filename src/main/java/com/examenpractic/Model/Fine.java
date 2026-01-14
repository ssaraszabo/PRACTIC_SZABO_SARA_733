package com.examenpractic.Model;

public class Fine {
    public int id;
    public int vehicleId;
    public FineReason reason;
    public int amount;
    public int timeSlot;

    public Fine() {
    }

    public Fine(int id, int vehicleId, FineReason reason, int amount, int timeSlot) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.reason = reason;
        this.amount = amount;
        this.timeSlot = timeSlot;
    }

    public int getId() {
        return id;
    }
    public int getVehicleId() {
        return vehicleId;
    }
    public FineReason getReason() {
        return reason;
    }
    public int getAmount() {
        return amount;
    }
    public int getTimeSlot() {
        return timeSlot;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public void setReason(FineReason reason) {
        this.reason = reason;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
    

}
