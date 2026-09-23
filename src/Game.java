public abstract class Game {

    private static int nextId = 1;   // shared counter — guarantees every game gets a unique id

    private final int id;
    private String name;
    private double price;
    private Genre genre;
    private double rating;

    public Game(String name, double price, Genre genre, double rating) {
        this.id = generateId();
        this.name = name;
        setPrice(price);
        this.genre = genre;
        this.rating = rating;
    }

    private static int generateId()
    {
        return nextId++;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        try {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }
            this.price = price;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            this.price = 0;   // fallback value if the input was invalid
        }
    }
    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    // Shared helper — subclasses can call this to print the common fields
    public  void displayBaseInfo()
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + getPrice());
        System.out.println("Genre: " + genre);
        System.out.println("Rating: " + rating);
    }


}
