/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by P. Balraj 2026

Balraj, P. (2026). CIS 505 Intermediate Java Programming.
Bellevue University.
*/

public class Team {

    // Class variables
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    // Constructor to initialize team name
    public Team(String teamName) {
        this.teamName = teamName;
    }

    // Adds a player to the team
    // Parameter: player (String)
    public void addPlayer(String player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        }
    }

    // Returns the array of players
    public String[] getPlayers() {
        return players;
    }

    // Returns the number of players
    public int getPlayerCount() {
        return playerCount;
    }

    // Returns the team name
    public String getTeamName() {
        return teamName;
    }
}
