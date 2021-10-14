package support;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import model.Board;
import model.Coordinate;
import model.Player;
import model.units.*;
import model.units.types.ShipType;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Generator {
    static final Generator instance = new Generator();

    Queue<String> names = new ArrayDeque<>(List.of(new String[]{"Bobs", "Pops"}));

    public Player generatePlayer(Board board) {
        return new Player(names.remove());
    }

    public Set<Unit> genUnits() {
        Set<Unit> units = new LinkedHashSet<>();
        if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
            combination1(units);
        } else {
            combination2(units);
        }
        return units;
    }
    private void combination1(Set<Unit> units) {
        units.add(new LongShip(new Coordinate(5, 2), new Coordinate(7, 2), ShipType.Cruiser));
        units.add(new LongShip(new Coordinate(4, 4), new Coordinate(4, 8), ShipType.Carrier));
        units.add(new LongShip(new Coordinate(1, 9), new Coordinate(1, 10), ShipType.Destroyer));
        units.add(new LongShip(new Coordinate(2, 10), new Coordinate(4, 10), ShipType.Cruiser));
        units.add(new LongShip(new Coordinate(8, 5), new Coordinate(8, 6), ShipType.Destroyer));
        units.add(new LongShip(new Coordinate(7, 8), new Coordinate(7, 9), ShipType.Destroyer));
    }
    private void combination2(Set<Unit> units) {
        units.add(new LongShip(new Coordinate(1, 1), new Coordinate(3, 1), ShipType.Cruiser));
        units.add(new LongShip(new Coordinate(7, 2), new Coordinate(8, 2), ShipType.Destroyer));
        units.add(new LongShip(new Coordinate(3, 5), new Coordinate(3, 6), ShipType.Destroyer));
        units.add(new LongShip(new Coordinate(10, 6), new Coordinate(10, 10), ShipType.Carrier));
        units.add(new LongShip(new Coordinate(6, 10), new Coordinate(9, 10), ShipType.Battleship));
    }

    private Generator() {}

    public static Generator getInstance() {
        return instance;
    }
}
