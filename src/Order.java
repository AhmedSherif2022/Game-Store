import java.util.ArrayList;
import java.util.List;

public class Order {

    private Player player;
    private List<Game> games;
    private OrderStatus status;

    public Order(Player player) {
        this.player = player;
        this.games = new ArrayList<>();
        this.status = OrderStatus.PENDING;   // every new order starts as PENDING
    }

    public void addGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        games.add(game);
    }

    public boolean removeGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        return games.remove(game);
    }

    public double calculateTotal()
    {
        double subtotal = 0;
        for (Game game : games)
        {
            subtotal += game.getPrice();
        }
        return player.applyDiscount(subtotal);
    }


    public OrderStatus getStatus() {
        return status;
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public Player getPlayer() {
        return player;
    }

    public void displayInfo() {
        System.out.println("===== Order Info =====");
        System.out.println("Player: " + player.getName());

        if (games.isEmpty()) {
            System.out.println("No games in this order.");
        } else {
            System.out.println("Games:");
            for (Game game : games) {
                System.out.println("- " + game.getName() + " ($" + game.getPrice() + ")");
            }
        }

        System.out.println("Total: $" + calculateTotal());
    }
}


