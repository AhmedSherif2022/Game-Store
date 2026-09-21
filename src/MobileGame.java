public class MobileGame extends Game
{

    private static final double IAP_SERVICE_FEE = 1.99;

    public MobileGame(int id, String name,double price,Genre genre, double rating)
    {
        super(name,id,price,genre,rating);

    }
    @Override
    public double getPrice()
    {
        try {
            double total = super.getPrice() + IAP_SERVICE_FEE;

            if (total < 0) {
                throw new IllegalStateException("Price cannot be negative");
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