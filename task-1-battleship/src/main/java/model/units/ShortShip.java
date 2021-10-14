package model.units;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import model.Coordinate;
import model.units.types.ShipType;


@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(callSuper = false)
public class ShortShip extends OneSquareUnit {
    ShipType shipType;

    public ShortShip(Coordinate coordinate) {
        super("ShortShip", coordinate);
        shipType = ShipType.Lil;
    }

    @Override
    public String toString() {
        return super.getUnitType() + " " + shipType + " ";
    }
}
