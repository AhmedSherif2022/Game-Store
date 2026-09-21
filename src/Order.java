import java.util.ArrayList;

public class Order {
private Player player;
private ArrayList<Game> Games;
private OrderStatus Orderstatus;

    public Order()
    {


    }
    public Order(Player player, ArrayList<Game> games, OrderStatus orderstatus)
    {
        this.player = player;
        Games = games;
        Orderstatus = orderstatus;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public ArrayList<Game> getGames()
    {
        return Games;
    }

    public void setGames(ArrayList<Game> games)
    {
        Games = games;
    }

    public OrderStatus getOrderstatus()
    {
        return Orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus)
    {
        Orderstatus = orderstatus;
    }
    public boolean addGame(Game game)
    {
        if (game == null) //Base case
        {
            return false;
        }
        Games.add(game);
        return true;
    }
    public boolean removeGame(Game game)
    {
        if (game == null)  //base case
        {
            return false;
        }
        return Games.remove(game);
    }
    public double calculateTotal()
    {
        double total = 0;
        for (Game game : Games)
        {
            total += game.getPrice();
        }
        return total;
    }
}
