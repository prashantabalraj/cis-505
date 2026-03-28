/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

import java.util.Scanner;

public class TestSportsTeamApp {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Control variable for loop
        String continueChoice = "y";

        // Loop to allow multiple team entries
        while (continueChoice.equalsIgnoreCase("y")) {

            // Prompt user for team name
            System.out.print("Enter team name: ");
            String teamName = input.nextLine();

            // Create Team object
            Team team = new Team(teamName);

            // Prompt user for player names
            System.out.print("Enter player names separated by commas: ");
            String playerInput = input.nextLine();

            // Split input string into array
            String[] playerList = playerInput.split(",");

            // Add each player to the team
            for (String player : playerList) {
                team.addPlayer(player.trim());
            }

            // Display number of players
            System.out.println("Number of players in team " + team.getPlayerCount());

            // Display players
            System.out.print("Players on team: ");
            String[] players = team.getPlayers();

            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(players[i]);

                if (i < team.getPlayerCount() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();

            // Ask user if they want to continue
            System.out.print("Do you want to enter another team? (y/n): ");
            continueChoice = input.nextLine();
        }

        // Close scanner
        input.close();
    }
}
