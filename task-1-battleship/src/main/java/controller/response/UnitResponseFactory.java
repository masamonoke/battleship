package controller.response;

import model.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitResponseFactory {

    List<AbstractUnitResponse> responses = new ArrayList<>();

    public UnitResponseFactory() {
        responses.add(new MinesweeperResponse());
        responses.add(new MineResponse());
        responses.add(new NullResponse());
        responses.add(new LongShipResponse());
    }

    public AbstractUnitResponse defineResponse(Unit unit) {
        return responses.stream().filter(x -> unit.getUnitName().equals(x.getResponseName())).findFirst().orElse(new NullResponse());
    }
}
