package model.units;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Coordinate;
import model.units.types.UnitType;

@AllArgsConstructor
@Getter
public abstract class Unit {
    String unitName;
    UnitType unitType;
    Coordinate startCoordinate;
    Coordinate endCoordinate;
}
