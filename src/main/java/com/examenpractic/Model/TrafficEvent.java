package com.examenpractic.Model;

public class TrafficEvent {
    public int id;
    public int vehicleId;
    public EventType type;
    public int severity;
    public int timeSlot;

    public TrafficEvent() {
    }

    public TrafficEvent(int id, int vehicleId, EventType type, int severity, int timeSlot) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.type = type;
        this.severity = severity;
        this.timeSlot = timeSlot;
    }
    public int getId() {
        return id;
    }
    public int getVehicleId() {
        return vehicleId;
    }
    public EventType getEventType() {
        return type;
    }
    public int getSeverity() {
        return severity;
    }
    public int getTimeSlot() {
        return timeSlot;
    }

}
