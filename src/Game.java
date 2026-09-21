public abstract class Game extends Order {
    private String name;
    private int id;
    private Genre genre;
    private double rating;
    private double price;
    public Game(String name, int id, Genre genre, double rating)
    {
        this.name = name;
        this.id = id;
        this.genre=genre;
        this.rating = rating;
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

    public void setId(int id)
    {
        this.id = id;
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
        if(price<0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        else
        {
           this.price=price;

        }
    }
    public double getPrice()
    {
            return price;
    }

    public boolean IsFree(double price)
    {
        if(price==0.0)
        {
          return true;
        }
     return false;
    }
    public abstract void displayInfo();
}
