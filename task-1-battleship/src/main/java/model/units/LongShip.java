package model.units;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import model.Coordinate;
import model.units.types.ShipType;
import model.units.types.UnitType;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@EqualsAndHashCode(callSuper = false)
public class LongShip extends Unit {
    ShipType shipType;
    @NonFinal @Setter
    int health;

    public LongShip(Coordinate startCoordinate, Coordinate endCoordinate, ShipType shipType) {
        super("LongShip", UnitType.MultiSquare, startCoordinate, endCoordinate);
        this.shipType = shipType;
        health = shipType.getValue();
    }

    @Override
    public String toString() {
        return unitType + " " + shipType + " ";
    }
}
