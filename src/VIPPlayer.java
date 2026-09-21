public class VIPPlayer extends Player
{
    private final static double DiscountVIPPlayer=0.25;
    public VIPPlayer(int id, String name)
    {
        super(id, name);
    }
    public double getdiscount()
    {
        return DiscountVIPPlayer;
    }

}
