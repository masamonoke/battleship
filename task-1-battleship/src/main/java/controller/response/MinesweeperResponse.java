package controller.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import model.Coordinate;
import model.units.Unit;

//TODO
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MinesweeperResponse extends AbstractUnitResponse {
    Coordinate coordinate;

    public MinesweeperResponse() {
        super("Minesweeper");
    }


    //TODO
    @Override
    public AbstractUnitResponse getResponse(Unit unit, Coordinate attackCoordinate) {
        return null;
    }
}
