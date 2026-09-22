//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main()
{
    GameStore store = new GameStore();

    // Add games to the store's catalog
    Game fifa = new PCGame("FIFA 27", 60.0, Genre.SPORTS, 4.5);
    Game godOfWar = new ConsoleGame("God of War", 50.0, Genre.ACTION, 4.8);
    Game candyCrush = new MobileGame("Candy Crush", 10.0, Genre.PUZZLE, 4.3);

    store.addGame(fifa);
    store.addGame(godOfWar);
    store.addGame(candyCrush);

    // Register players
    Player ziad = new VIPPlayer(1, "Ziad");
    Player mohammed = new RegularPlayer(2, "Mohammed");

    store.registerPlayer(ziad);
    store.registerPlayer(mohammed);

    // Create an order for Ziad, add games, checkout
    Order order = store.createOrder(ziad);
    order.addGame(fifa);
    order.addGame(candyCrush);

    order.displayInfo();
    System.out.println();
    order.checkout();

    System.out.println();

    // Register both players for the tournament and start it
    store.registerForTournament(ziad);
    store.registerForTournament(mohammed);

    store.startTournament();

    System.out.println();
    Player winner = store.getTournamentWinner();
    System.out.println("Tournament winner: " + winner.getName());
}





