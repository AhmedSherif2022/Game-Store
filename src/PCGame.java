public class PCGame extends Game
{
     private String operatingSystemRequired;
     private final static double DIGITAL_DISTRIBUTION_FEE=200; // The price of the PCGame


     public PCGame(String name, int id, Genre genre, double rating, String operatingSystemRequired)
    {
        super(name, id, genre, rating);
        this.operatingSystemRequired = operatingSystemRequired;
    }
    @Override
    public double getPrice()
    {
        return super.getPrice()+ DIGITAL_DISTRIBUTION_FEE;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Genre: " + getGenre());
        System.out.println("Rating: " + getRating());
        System.out.println("The Operating System Required ="+operatingSystemRequired);


    }
}
