public class ConsoleGame extends Game
{
 private String consoleType;
 private boolean isExclusive;

    public ConsoleGame(String name, int id, Genre genre, double rating, String consoleType, boolean isExclusive)
    {
        super(name, id, genre, rating);
        this.consoleType = consoleType;
        this.isExclusive = isExclusive;
    }

    public void displayInfo()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Genre: " + getGenre());
        System.out.println("Rating: " + getRating());
        System.out.println("consoleType"+consoleType);
        System.out.print("isExclusive"+isExclusive);
    }

}
