//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main()
{
     //Test  (Games and Subclasses)
    PCGame fifa = new PCGame("FIFA 27",100, Genre.SPORTS,4.9 );
    ConsoleGame godOfWar = new ConsoleGame("God of War", 50.00, Genre.ACTION, 4.8);
    MobileGame candyCrush = new MobileGame("Candy Crush", 10.0, Genre.PUZZLE, 4.3);
    System.out.println(fifa.getPrice());
    System.out.println(godOfWar.getPrice());
    System.out.println(candyCrush.getPrice());

    System.out.println(" ");



    //Test (Players and Subclasses)
    Player regular = new RegularPlayer(1, "Mohammed");
    Player vip = new VIPPlayer(2, "Ahmed");

    System.out.println(regular.getName() + " discount: " + regular.getdiscount());
    System.out.println(vip.getName() + " discount: " + vip.getdiscount());

    double price = 100.0;
    System.out.println(regular.getName() + " pays: $" + regular.applyDiscount(price));
    System.out.println(vip.getName() + " pays: $" + vip.applyDiscount(price));



    //Tournament ()
    Tournament summerCup = new Tournament();

    Player ahmed = new VIPPlayer(1, "Ahmed");
    Player mohammed = new RegularPlayer(2, "Mohammed");
    Player sara = new VIPPlayer(3, "Sara");
    Player omar = new RegularPlayer(4, "Omar");

    summerCup.registerPlayer(ahmed);
    summerCup.registerPlayer(mohammed);
    summerCup.registerPlayer(sara);
    summerCup.registerPlayer(omar);



    System.out.println();
    summerCup.startTournament();

    System.out.println();
    summerCup.displayInfo();


    System.out.println();
    //Order Example
    Player ziad = new VIPPlayer(1, "Ziad");
    Order order = new Order(ziad);

    order.addGame(new PCGame("FIFA 27", 60.0, Genre.SPORTS, 4.5));
    order.addGame(new MobileGame("Candy Crush", 20.0, Genre.PUZZLE, 4.3));
    
    System.out.println();
    order.checkout();
    order.displayInfo();

}



