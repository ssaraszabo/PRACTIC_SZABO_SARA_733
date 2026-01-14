package com.examenpractic.Controller;

import com.examenpractic.Model.*;
import com.examenpractic.Repository.VehicleRepository;
import com.examenpractic.Service.EventService;
import com.examenpractic.Service.VehicleService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.examenpractic.Model.Vehicle;

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
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());}
        }
}
