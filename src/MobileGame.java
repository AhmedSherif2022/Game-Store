public class MobileGame extends Game {

    private double fileSizeMB;
    private boolean hasInAppPurchases;

    // A flat fee the STORE charges for supporting in-app purchase infrastructure
    private static final double IAP_SERVICE_FEE = 4.99;

    public MobileGame(int id, String name, double price, Genre genre, double rating,
                      double fileSizeMB, boolean hasInAppPurchases) {
        super(name,id, genre,rating);
        this.fileSizeMB = fileSizeMB;
        this.hasInAppPurchases = hasInAppPurchases;
    }

    @Override
    public double getPrice() {
        double basePrice = super.getPrice();
        if (hasInAppPurchases) {
            // the store adds its service fee for handling IAP transactions
            return basePrice + IAP_SERVICE_FEE;
        }
        return basePrice;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public boolean isHasInAppPurchases() {
        return hasInAppPurchases;
    }
    public void displayInfo()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Genre: " + getGenre());
        System.out.println("Rating: " + getRating());
        System.out.println("filesizeMB"+fileSizeMB);
        System.out.println("hasInAppPurchases"+hasInAppPurchases);

    }
}