public class ConsoleGame extends Game
{
 private String consoleType;
 private boolean isExclusive;
 private final static double CONSOLE_LICENSE_PRICE=5.00;

    public ConsoleGame(String name, int id,double price, Genre genre, double rating)
    {
        super(name,id,price, genre, rating);

    }
    @Override
    public double getPrice() {
        try {
            double total = super.getPrice() + CONSOLE_LICENSE_PRICE;

            if (total < 0) {
                throw new IllegalStateException("Price cannot be negative or zero");
            }

            return total;

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
    public void displayInfo()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Genre: " + getGenre());
        System.out.println("Rating: " + getRating());

    }

}
