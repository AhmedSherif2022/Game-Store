# Game Store

A small Java game-store domain model demonstrating object-oriented programming concepts such as inheritance, abstraction, interfaces, encapsulation, polymorphism, collections, and enums.

The project models a store that can:

- Catalog PC, console, and mobile games
- Register regular and VIP players
- Create orders and calculate player-specific discounts
- Add and remove games from orders
- Register players for a randomized tournament
- Display catalog, order, player, and tournament information in the console

## Project Structure

| File | Responsibility |
| --- | --- |
| `Game.java` | Abstract base class for all games; assigns unique IDs and stores shared game data |
| `PCGame.java` | Game sold for PC with a `$15.00` digital distribution fee |
| `ConsoleGame.java` | Game sold for consoles with a `$10.00` console license fee |
| `MobileGame.java` | Game sold for mobile platforms with a `$5.00` app-store fee |
| `Genre.java` | Supported game genres |
| `Player.java` | Abstract player base class and discount application logic |
| `RegularPlayer.java` | Player with a 15% discount |
| `VIPPlayer.java` | Player with a 25% discount |
| `Discountable.java` | Contract for classes that provide a discount rate |
| `Order.java` | Holds a player's games and calculates the final total |
| `OrderStatus.java` | Available order states |
| `GameStore.java` | Coordinates games, players, orders, and the tournament |
| `Tournament.java` | Manages registration and randomized elimination matches |
| `Main.java` | Console demonstration of the application |

## Requirements

- Java Development Kit (JDK)
- An IDE such as IntelliJ IDEA, or a command-line Java toolchain

`Main.java` uses Java's concise unnamed-class/instance-main syntax. Run it with a JDK and IDE configuration that supports that syntax. If your environment does not support it, change the entry point to the conventional form:

```java
public class Main {
    public static void main(String[] args) {
        // existing Main.java code
    }
}
```

## Running the Example

### IntelliJ IDEA

1. Open the `src` folder as a Java source root or open its containing project.
2. Ensure a compatible JDK is selected for the project.
3. Open `Main.java`.
4. Run `Main` using the run icon or the IDE's Run action.

### Command line

From this directory, compile all source files and run the demo:

```bash
javac *.java
java Main
```

On Windows PowerShell, the same commands are:

```powershell
javac *.java
java Main
```

The output includes order information, discounted totals, tournament rounds, and the randomly selected winner.

## Domain Rules

### Games and pricing

Every game receives a unique numeric ID from the shared counter in `Game`.

The base price is validated when a game is created or updated. A negative base price is replaced with `0.00` and an error is printed.

The displayed and billed price is calculated by the concrete game type:

| Game type | Effective price |
| --- | --- |
| PC | Base price + `$15.00` |
| Console | Base price + `$10.00` |
| Mobile | Base price + `$5.00` |

For example, a PC game with a base price of `$29.99` has an effective price of `$44.99`.

Supported genres are:

- `ACTION`
- `SPORTS`
- `RPG`
- `ADVENTURE`
- `PUZZLE`

### Players and discounts

`Player` implements `Discountable`. Its `applyDiscount` method calculates:

```text
final total = subtotal * (1 - discount rate)
```

| Player type | Discount |
| --- | ---: |
| Regular player | 15% |
| VIP player | 25% |

The discount applies to the sum of the effective prices of all games in the order.

### Orders

A new order starts with status `PENDING`. Games can be added or removed, and `calculateTotal()` returns the discounted total for the order's player.

`OrderStatus` currently defines:

- `PENDING`
- `CHECKED_OUT`
- `CANCELLED`

At present, the `Order` class does not provide methods that transition an order to `CHECKED_OUT` or `CANCELLED`; newly created orders remain `PENDING`.

Null games are rejected by `addGame` and `removeGame` with an `IllegalArgumentException`.

### Tournaments

- A tournament accepts up to 10 players.
- The same player object cannot be registered twice.
- A tournament cannot start without registered players.
- Matches are decided randomly.
- With an odd number of players in a round, the last player advances automatically.
- The winner is available through `getWinner()` after the tournament starts.

## Example Usage

```java
GameStore store = new GameStore();

Game pcGame = new PCGame("Minecraft", 29.99, Genre.ADVENTURE, 4.9);
Game consoleGame = new ConsoleGame("Spider-Man 2", 69.99, Genre.ACTION, 4.7);

store.addGame(pcGame);
store.addGame(consoleGame);

Player vipPlayer = new VIPPlayer(1, "Sara");
store.registerPlayer(vipPlayer);

Order order = store.createOrder(vipPlayer);
order.addGame(pcGame);
order.addGame(consoleGame);

System.out.println("Total: $" + order.calculateTotal());
order.displayInfo();
```

For the example above, the subtotal is based on the effective platform prices, then the VIP discount is applied:

```text
PC:      29.99 + 15.00 = 44.99
Console: 69.99 + 10.00 = 79.99
Subtotal: 124.98
VIP total: 124.98 * 0.75 = 93.735
```

The code does not round monetary values, so Java's raw `double` result may print more than two decimal places.

## Main Demonstration Flow

`Main.java` demonstrates the complete current flow:

1. Create a `GameStore`.
2. Create one PC game, one console game, and one mobile game.
3. Add the games to the store.
4. Register two VIP players and one regular player.
5. Create orders and add games to each order.
6. Display each order and its discounted total.
7. Register the players for a tournament.
8. Start the tournament and print the winner.

## Design Concepts Demonstrated

- **Abstraction:** `Game` and `Player` define shared state and behavior for specialized objects.
- **Inheritance:** `PCGame`, `ConsoleGame`, `MobileGame`, `RegularPlayer`, and `VIPPlayer` extend base classes.
- **Polymorphism:** `Game` references use the concrete game's overridden `getPrice()` implementation.
- **Interface-based behavior:** `Discountable` requires a discount rate from player types.
- **Encapsulation:** Collections returned by `GameStore`, `Order`, and related classes are defensive copies.
- **Composition:** `GameStore` contains games, players, orders, and a tournament.
- **Enums:** `Genre` and `OrderStatus` restrict values to known options.

## Current Limitations and Extension Ideas

The project is intentionally compact. Possible next improvements include:

- Add order checkout and cancellation methods that update `OrderStatus`.
- Add a unique order ID and expose the store's order history.
- Validate ratings, names, IDs, and null players at construction time.
- Replace `double` with `BigDecimal` for currency calculations and round totals to two decimals.
- Add search and filtering by game name, genre, platform, or rating.
- Add stock or inventory quantities.
- Add deterministic tournament injection or a seed for repeatable tests.
- Add `equals` and `hashCode` for players and games when identity should be value-based.
- Add unit tests for pricing, discounts, validation, order totals, and tournament limits.

## License

No license is currently specified for this project.
