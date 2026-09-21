//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main()
{
    PCGame minecraft = new PCGame("Minecraft", 1,200, Genre.ADVENTURE, 4.9 );
    MobileGame candyCrush = new MobileGame(1, "Candy Crush",300,Genre.PUZZLE, 4.3);
    ConsoleGame godOfWar = new ConsoleGame("God of War", 1,400, Genre.ACTION, 4.8);
    System.out.println(minecraft.getPrice());
    System.out.println(candyCrush.getPrice());
    System.out.println(godOfWar.getPrice());
    minecraft.displayInfo();
    candyCrush.displayInfo();
    godOfWar.displayInfo();


    System.out.println(" ");
    //(Players and subclasses for thr player ) test
    Player regular = new RegularPlayer(1, "Mohammed");
    Player vip = new VIPPlayer(2, "Ahmed");

    System.out.println(regular.getName() + " discount: " + regular.getdiscount());
    System.out.println(vip.getName() + " discount: " + vip.getdiscount());

    double price = 100.0;
    System.out.println(regular.getName() + " pays: $" + regular.applyDiscount(price));
    System.out.println(vip.getName() + " pays: $" + vip.applyDiscount(price));
        }


