public class PCGame extends Game
{

    private static final double DIGITAL_DISTRIBUTION_FEE = 4.00;
     public PCGame(String name, int id,double price,Genre genre, double rating)
    {
        super(name, id,price, genre, rating);

    }
    @Override
    public double getPrice() {
        try {
            double total = super.getPrice() + DIGITAL_DISTRIBUTION_FEE;

            if (total < 0) {
                throw new IllegalStateException("Price cannot be negative");
            }

            return total;

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
    @Override
    public void displayInfo()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Genre: " + getGenre());
        System.out.println("Rating: " + getRating());

    }
}
