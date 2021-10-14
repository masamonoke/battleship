package controller.response;


import model.Coordinate;
import model.units.Unit;


public class NullResponse extends AbstractUnitResponse {
    public NullResponse(String message) {
        super("Null");
        super.setMessage(message);
    }

    public NullResponse() {
        super("Null");
    }

    //TODO
    @Override
    public AbstractUnitResponse getResponse(Unit unit, Coordinate attackCoordinate) {
        return null;
    }
}
