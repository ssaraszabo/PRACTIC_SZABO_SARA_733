package com.examenpractic.Service;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import com.examenpractic.Model.Vehicle;
import com.examenpractic.Model.VehicleStatus;
import com.examenpractic.Model.VehicleType;

public class VehicleService {

    // TASK 2 
    public List<Vehicle> filterTeamByStatus(List<Vehicle> vehicleList, VehicleType type, VehicleStatus status) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getType() == type) 
                .filter(vehicle -> vehicle.getStatus() == status)
                .collect(Collectors.toList());
    }

    // TASK 3 
    public List<Vehicle> getSortedVehicles(List<Vehicle> vehicleList) {
        List<Vehicle> sortedList = new ArrayList<>(vehicleList);
        sortedList.sort(
                Comparator.comparing(Vehicle::getOwnerCity)
                        .reversed()
                        .thenComparing(Vehicle::getId) 
        );

        return sortedList;
    }

    // TASK 4 
    public void saveVehiclesToFile(List<Vehicle> vehiclesList, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Vehicle vehicle : vehiclesList) {
                writer.println(vehicle.toString());
            }
        }
    }
}