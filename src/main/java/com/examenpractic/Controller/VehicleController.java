package com.examenpractic.Controller;

import com.examenpractic.Model.*;
import com.examenpractic.Repository.VehicleRepository;
import com.examenpractic.Service.EventService;
import com.examenpractic.Service.VehicleService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class VehicleController {
    public void run() {
        try {
            VehicleRepository repo = new VehicleRepository();
            VehicleService fahrerService = new VehicleService();
            EventService ereignisService = new EventService();
            Scanner scanner = new Scanner(System.in);

            // TASK 1 
            List<Vehicle> vehicle = repo.readVehicle("vehicles.json");
            List<Fine> fine = repo.readStrafe("fines.json");
            List<TrafficEvent> trafficEvents = repo.readRennenEreignis("events.json");

            System.out.println("Vehicles loaded: " + vehicle.size());
            System.out.println("Events loaded: " + trafficEvents.size());
            System.out.println("Fines loaded: " + fine.size());

            //print all vehicles 
            for (Vehicle v : vehicle) {
                System.out.println(v);
            }

            // TASK 2 – Filter vehicles by type and status
            System.out.print("\nInput type to filter: ");
            String teamInput = scanner.nextLine();
            System.out.print("\nInput status to filter: ");
            String statusInput = scanner.nextLine();

            List<Vehicle> filtered = fahrerService.filterTeamByStatus(vehicle, VehicleType.valueOf(teamInput.toUpperCase()), VehicleStatus.valueOf(statusInput.toUpperCase()));
            System.out.println("Filtered Vehicles (" + teamInput + " & " + statusInput + "):");
            for (Vehicle v : filtered) {
                System.out.println(v);
            }

            // TASK 3 & TASK 4 – Sort vehicles & print to file
            List<Vehicle> sorted = fahrerService.getSortedVehicles(vehicle);
            try {
                fahrerService.saveVehiclesToFile(sorted, "vehicles_sorted.txt");
                System.out.println("\nSuccessfully saved sorted vehicles to vehicles_sorted.txt");
            } catch (IOException e) {
                System.err.println("File error: " + e.getMessage());
            }


            // TASK 5 – Computed points
            System.out.println("\nComputed points for first 5 events:");
            for (int i = 0; i < 5 && i < trafficEvents.size(); i++) {
                TrafficEvent e = trafficEvents.get(i);
                int computedPoints = ereignisService.calculateComputedPoints(e);

                System.out.println(
                        "Event " + e.getId() 
                        + " -> severity=" + e.getSeverity()
                        + " -> riskScore=" + computedPoints
                );
            }
/* 
            // TASK 7 – Generate report
            EventService.generateReport(trafficEvents, "traffic_report.txt");
*/
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());}
        }
}
