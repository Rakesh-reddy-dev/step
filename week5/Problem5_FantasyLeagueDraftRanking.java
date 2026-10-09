import java.util.Arrays;

public class Problem5_FantasyLeagueDraftRanking {

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Established players qualify based on matches played alone.
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Newer players must have enough experience and must not be injured.
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            // Sort by batting average from highest to lowest.
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftablePlayers = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(player.matchesPlayed, player.injured)) {
                draftablePlayers[count] = player;
                count++;
            }
        }

        draftablePlayers = Arrays.copyOf(draftablePlayers, count);
        Arrays.sort(draftablePlayers);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftablePlayers.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftablePlayers[i].name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
