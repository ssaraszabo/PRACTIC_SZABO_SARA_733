package com.examenpractic.Service;

import com.examenpractic.Model.TrafficEvent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map;

import javax.swing.event.DocumentEvent.EventType;

import com.examenpractic.Model.Vehicle;
import com.examenpractic.Model.Fine;
import com.examenpractic.Model.VehicleStatus;
import com.examenpractic.Model.VehicleType;
import com.examenpractic.Repository.VehicleRepository;

public class EventService {

    // TASK 5 

    /*Regeln zur Berechnung: 
    ● SPEEDING → riskScore = severity * 2 
    ● RED_LIGHT → riskScore = severity * 3 
    ● ACCIDENT → riskScore = severity * 5 
    ● PRIORITY_PASS → riskScore = severity * 1  */

    public int calculateComputedPoints(TrafficEvent e) {
        int points = e.getSeverity();

        return switch (e.getEventType()) {
            case SPEEDING -> points * 2;
            case RED_LIGHT -> points * 3;
            case ACCIDENT -> points * 5;
            case PRIORITY_PASS -> points * 1;
            default -> points;
        };
    }
/* 
    // TASK 7 
    public static void generateReport(List<TrafficEvent> trafficEvents, String filename) throws IOException {
        Map<EventType, Integer> counts = new HashMap<>();
        for (TrafficEvent e : trafficEvents) {
            counts.put(e.getEventType(), counts.getOrDefault(e.getEventType(), 0) + 1);
        }

        try (PrintWriter writer = new PrintWriter(filename)) {
            counts.entrySet().stream()
                .sorted(Map.Entry.<EventType, Integer>comparingByValue().reversed())
                .forEach(entry -> writer.println(entry.getKey() + " -> " + entry.getValue()));
        }
    }*/
}
