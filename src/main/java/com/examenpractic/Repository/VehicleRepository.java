package com.examenpractic.Repository;


import com.examenpractic.Model.Fine;
import com.examenpractic.Model.TrafficEvent;
import com.examenpractic.Model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class VehicleRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //vehicles.json
    public List<Vehicle> readVehicle(String filepath) throws IOException {
        return Arrays.asList(
                objectMapper.readValue(new File(filepath), Vehicle[].class)
        );
    }

    //events.json
    public List<TrafficEvent> readRennenEreignis(String filepath)
            throws IOException {
        return Arrays.asList(
                objectMapper.readValue(new File(filepath),
                        TrafficEvent[].class)
        );
    }

    //fines.json
    public List<Fine> readStrafe(String filepath) throws IOException {
        return Arrays.asList(
                objectMapper.readValue(new File(filepath), Fine[].class)
        );
    }
}
