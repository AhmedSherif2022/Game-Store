import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament
{
    private List<Player> players;
    private Player winner;
    private static final int MAX_NUMBER_PLAYERS=10;

    public Tournament()
    {
        this.players = new ArrayList<>();
    }
    public void registerPlayer(Player player)
    {
        try {
            if (players.contains(player)) {
                throw new IllegalArgumentException("Player is already registered in this tournament");
            }
            if (players.size() >= MAX_NUMBER_PLAYERS) {
                throw new IllegalStateException("Tournament is full");
            }
            players.add(player);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void startTournament() {
        try {
            if (players.isEmpty()) {
                throw new IllegalStateException("Cannot start tournament with no players");
            }

            List<Player> remainingPlayers = new ArrayList<>(players);
            Random random = new Random();
            int round = 1;

            while (remainingPlayers.size() > 1) {
                System.out.println("--- Round " + round + " ---");
                List<Player> nextRound = new ArrayList<>();

                for (int i = 0; i < remainingPlayers.size() - 1; i += 2) {
                    Player player1 = remainingPlayers.get(i);
                    Player player2 = remainingPlayers.get(i + 1);

                    Player matchWinner = random.nextBoolean() ? player1 : player2;
                    System.out.println(player1.getName() + " vs " + player2.getName()
                            + " -> Winner: " + matchWinner.getName());

                    nextRound.add(matchWinner);
                }

                // if there's an odd player out, they automatically advance
                if (remainingPlayers.size() % 2 != 0) {
                    Player byePlayer = remainingPlayers.get(remainingPlayers.size() - 1);
                    System.out.println(byePlayer.getName() + " advances automatically (odd number of players)");
                    nextRound.add(byePlayer);
                }

                remainingPlayers = nextRound;
                round++;
            }

            winner = remainingPlayers.get(0);
            System.out.println("Tournament winner: " + winner.getName());

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public Player getWinner()
    {
        return winner;
    }
    public void displayInfo()
    {
        System.out.println("===== Tournament Info =====");
        System.out.println("Registered Players: " + players.size() + "/" + MAX_NUMBER_PLAYERS);

        if (players.isEmpty()) {
            System.out.println("No players registered yet.");
        } else {
            for (Player p : players) {
                System.out.println("- " + p.getName());
            }
        }

        if (winner != null) {
            System.out.println("Winner: " + winner.getName());
        } else {
            System.out.println("Tournament has not started yet, or has no winner.");
        }
    }
}
