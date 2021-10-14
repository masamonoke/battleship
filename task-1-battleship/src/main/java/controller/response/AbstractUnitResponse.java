package controller.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import model.Coordinate;
import model.units.Unit;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractUnitResponse {

    String message = "";
    String responseName;
    boolean shouldSwitchMovePlayer = false;

    public AbstractUnitResponse(String responseName) {
        this.responseName = responseName;
    }


    public abstract AbstractUnitResponse getResponse(Unit unit, Coordinate attackCoordinate);
}
