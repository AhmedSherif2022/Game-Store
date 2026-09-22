public class MobileGame extends Game
{
     private final static double APP_STORE_FEE=5.00;

    public MobileGame(String name, double price, Genre genre, double rating)
    {
        super(name, price, genre, rating);
    }
    public double getPrice()
    {
        return super.getPrice() + APP_STORE_FEE;
    }
    @Override
    public void displayInfo()
    {
        displayBaseInfo();
    }
}