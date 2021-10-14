package model.units;

import model.Coordinate;
import model.units.types.ShipType;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void correctSetTest() {
        LongShip longShip1 = new LongShip(new Coordinate(0, 0), new Coordinate(0, 1), ShipType.Destroyer);
        LongShip longShip2 = new LongShip(new Coordinate(0, 0), new Coordinate(0, 1), ShipType.Destroyer);
        Set<Unit> unitSet = new LinkedHashSet<>();
        unitSet.add(longShip1);
        unitSet.add(longShip2);
        assertEquals(1, unitSet.size());
    }
}