package controller.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import model.Coordinate;
import model.units.Unit;

//TODO
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MineResponse extends AbstractUnitResponse {
    Coordinate coordinate;

    public MineResponse() {
        super("Mine");
    }

    //TODO
    @Override
    public AbstractUnitResponse getResponse(Unit unit, Coordinate attackCoordinate) {
        return null;
    }
}
