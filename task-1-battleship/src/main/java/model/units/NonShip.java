package model.units;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import model.Coordinate;
import model.units.types.NonShipType;

@Getter
@EqualsAndHashCode(callSuper = false)
public class NonShip extends OneSquareUnit {
    NonShipType nonShipType;

    public NonShip(@NonNull Coordinate coordinate, NonShipType nonShipType) {
        super(nonShipType.name(), coordinate);
        this.nonShipType = nonShipType;
    }
}
