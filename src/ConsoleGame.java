public class ConsoleGame extends Game
{
 private String consoleType;
 private boolean isExclusive;
 private final static double CONSOLE_LICENSE_PRICE=10.00;

    public ConsoleGame(String name,double price, Genre genre, double rating) {
        super(name,price, genre, rating);
    }
    public double getPrice()
    {
        return super.getPrice() + CONSOLE_LICENSE_PRICE;
    }
    public void displayInfo()
    {
        displayBaseInfo();
    }

}
