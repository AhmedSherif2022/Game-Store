//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main()
{
    GameStore store = new GameStore();

    Game minecraft = new PCGame("Minecraft", 29.99, Genre.ADVENTURE, 4.9);
    Game spiderMan = new ConsoleGame("Spider-Man 2", 69.99, Genre.ACTION, 4.7);
    Game subwaySurfers = new MobileGame("Subway Surfers", 0.0, Genre.PUZZLE, 4.2);

    store.addGame(minecraft);
    store.addGame(spiderMan);
    store.addGame(subwaySurfers);

    Player sara = new VIPPlayer(1, "Sara");
    Player omar = new RegularPlayer(2, "Omar");
    Player laila = new VIPPlayer(3, "Laila");

    store.registerPlayer(sara);
    store.registerPlayer(omar);
    store.registerPlayer(laila);

    // Sara's order — VIP player
    Order saraOrder = store.createOrder(sara);
    saraOrder.addGame(minecraft);
    saraOrder.displayInfo();
    System.out.println();




    // Omar's order — Regular player
    Order omarOrder = store.createOrder(omar);
    omarOrder.addGame(spiderMan);
    omarOrder.addGame(subwaySurfers);
    omarOrder.displayInfo();
    System.out.println();




    // Laila's order — VIP player
    Order lailaOrder = store.createOrder(laila);
    lailaOrder.addGame(minecraft);
    lailaOrder.addGame(spiderMan);
    lailaOrder.addGame(subwaySurfers);
    lailaOrder.displayInfo();
    System.out.println();


    store.registerForTournament(sara);
    store.registerForTournament(omar);
    store.registerForTournament(laila);



    System.out.println("\n--------Starting the tournament-------");
    store.startTournament();

    System.out.println("\n------------Result-----------");
    Player winner = store.getTournamentWinner();
    System.out.println("Tournament winner: " + winner.getName());





}






