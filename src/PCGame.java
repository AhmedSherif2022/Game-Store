public class PCGame extends Game
{

    private static final double DIGITAL_DISTRIBUTION_FEE = 15.00;
     public PCGame(String name,double price,Genre genre, double rating)
    {
        super(name,price, genre, rating);

    }
    @Override
    public double getPrice()
    {
        return super.getPrice()+DIGITAL_DISTRIBUTION_FEE;
    }

    @Override
    public void displayInfo()
    {
        displayBaseInfo();

    }
}
