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
/* 
    // ====================================================
    // TASK 3 – Sort drivers
    // Sorting rules:
    //  - skillLevel descending
    //  - name ascending (if skillLevel is equal)
    // ====================================================
    public List<Fahrer> getSortedFahrer(List<Fahrer> fahrerList) {
        List<Fahrer> sortedList = new ArrayList<>(fahrerList);
        sortedList.sort(
                Comparator.comparing(Fahrer::getSkillLevel)
                        .reversed()
                        .thenComparing(Fahrer::getName) 
        );

        return sortedList;
    }

    // ====================================================
    // TASK 4 – Save sorted drivers to file
    // ====================================================
    public void saveFahrerToFile(List<Fahrer> fahrerList, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Fahrer fahrer : fahrerList) {
                writer.println(fahrer.toString());
            }
        }
    }*/
}