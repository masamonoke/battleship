package model.units;

import lombok.*;
import lombok.experimental.FieldDefaults;
import model.Coordinate;
import model.units.types.UnitType;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class OneSquareUnit extends Unit {
    Coordinate coordinate;

    public OneSquareUnit(String unitName, Coordinate coordinate) {
        super(unitName, UnitType.OneSquare, coordinate, coordinate);
        this.coordinate = coordinate;
    }
}
