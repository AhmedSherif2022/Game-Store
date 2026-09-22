import java.util.ArrayList;
import java.util.List;

public class GameStore
{

    private List<Game> availableGames;
    private List<Player> players;
    private List<Order> orders;
    private Tournament tournament;

    public GameStore()
    {
        this.availableGames = new ArrayList<>();
        this.players = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.tournament = new Tournament();
    }


    public void addGame(Game game)
    {
        availableGames.add(game);
    }

    public List<Game> getAvailableGames()
    {
        return new ArrayList<>(availableGames);
    }
    public void registerPlayer(Player player)
    {
        players.add(player);
    }

    public List<Player> getPlayers()
    {
        return new ArrayList<>(players);
    }


    public Order createOrder(Player player)
    {
        Order order = new Order(player);
        orders.add(order);
        return order;
    }

    public void registerForTournament(Player player)
    {
        tournament.registerPlayer(player);
    }

    public void startTournament()
    {
        tournament.startTournament();
    }

    public Player getTournamentWinner()
    {
        return tournament.getWinner();
    }

    public void displayTournamentInfo()
    {
        tournament.displayInfo();
    }
}
