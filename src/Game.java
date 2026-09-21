public abstract class Game extends Order {
    private static int nextId = 1;
    private String name;
    private final int id;
    private Genre genre;
    private double rating;
    private double price;
    public Game(String name, int nextid,double price, Genre genre, double rating)
    {
        this.name = name;
        this.id = generateId();
        this.price=price;
        this.genre=genre;

        this.rating = rating;
    }
    private static int generateId()
    {
        return nextId++;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(Genre genre)
    {
        this.genre=genre;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public double getPrice()
    {
            return price;
    }
    public abstract void displayInfo();
}
