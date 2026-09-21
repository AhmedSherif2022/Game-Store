public class RegularPlayer extends Player
{
    private final static double DiscountRegularPlayer=0.15;
    public RegularPlayer(int id, String name)
    {
        super(id, name);
    }
    public double getdiscount()
    {
        return DiscountRegularPlayer;
    }


}
