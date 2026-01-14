package com.examenpractic.Service;

import com.examenpractic.Model.TrafficEvent;

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
    // =========================
    // TASK 6 – Ranking & Winning Team
    // =========================
    public void printTop5AndWinningTeam(
            List<Fahrer> fahrerListe,
            List<RennenEreignis> eventListe,
            List<Strafe> strafenListe) {

        Map<Integer, Integer> driverScores = new HashMap<>();

        // Initialize all drivers with 0 points
        for (Fahrer f : fahrerListe) {
            driverScores.put(f.getId(), 0);
        }

        // Add event points
        for (RennenEreignis e : eventListe) {
            driverScores.put(
                    e.getFahrerId(),
                    driverScores.get(e.getFahrerId())
                            + calculateComputedPoints(e)
            );
        }

        // Subtract penalty seconds
        for (Strafe s : strafenListe) {
            driverScores.put(
                    s.getFahrerId(),
                    driverScores.get(s.getFahrerId()) - s.getSeconds() 
            );
        }

        // Sort drivers
        List<Fahrer> sortedFahrer = new ArrayList<>(fahrerListe);
        sortedFahrer.sort((f1, f2) -> {
            int score1 = driverScores.get(f1.getId());
            int score2 = driverScores.get(f2.getId());
            // Sort by totalScore descending, then name ascending [cite: 169, 170]
            if (score1 != score2)
                return Integer.compare(score2, score1);
            return f1.getName().compareTo(f2.getName());
        });

        //print top 5
        for (int i = 0; i < 5 && i < sortedFahrer.size(); i++) {
            Fahrer f = sortedFahrer.get(i);
            System.out.println(
                    (i + 1) + ". " + f.getName() + " (" + f.getTeam() + ") -> "
                            + driverScores.get(f.getId())
            );
        }

        //winning team
        if (!sortedFahrer.isEmpty()) {
            System.out.println(
                    "Winning team: " + sortedFahrer.get(0).getTeam()
            );
        }
    }

    // =========================
    // TASK 7 – Race report file
    // =========================
    public void generateReport(
            List<RennenEreignis> ereignis,
            String fileName) throws IOException {

        Map<EreignisTyp, Integer> counts = new HashMap<>();

        //all types represented as shown in requirements
        for (EreignisTyp typ : EreignisTyp.values()) {
            counts.put(typ, 0);
        }

        for (RennenEreignis e : ereignis) {
            counts.put(
                    e.getTyp(),
                    counts.get(e.getTyp()) + 1
            );
        }

        try (PrintWriter writer = new PrintWriter(fileName)) {
            counts.entrySet().stream()
                .sorted(Map.Entry.<EreignisTyp, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    writer.println(entry.getKey() + " -> " + entry.getValue());
                });
        }
    }*/
}
