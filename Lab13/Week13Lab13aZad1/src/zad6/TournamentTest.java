package zad6;

import java.util.*;

public class TournamentTest {
    public static void main(String[] args) {
        TreeMap<String, String> teams = new TreeMap<>();
        initializeTeams(teams);

        System.out.printf("Size: %d\nChicago Team: %s\n\n", teams.size(), teams.get("Chicago"));

        teams.put("San Francisco", "Niners");

        System.out.printf("Is San Diego registered? %s\n\n", teams.containsKey("San Diego") ? "Yes" : "No");

        teams.remove("Denver");

        teams.put("Dallas", "Cowboys");

        for (String city : teams.keySet()) {
            System.out.printf("%s => %s\n", city, teams.get(city));
        }

        System.out.println("\nReverse Order:");

        List<Map.Entry<String, String>> entries = new ArrayList<>(teams.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue());
        Collections.reverse(entries);

        for (Map.Entry<String, String> entry : entries) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }
    }

    private static void initializeTeams(TreeMap<String, String> teams) {
        teams.put("San Francisco", "Forty-niners");
        teams.put("Chicago", "Bears");
        teams.put("Denver", "Broncos");
        teams.put("Seattle", "Seahawks");
        teams.put("Detroit", "Lions");
        teams.put("Miami", "Dolphins");
    }
}
