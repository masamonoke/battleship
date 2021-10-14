package controller.response;

import lombok.Getter;
import lombok.Setter;
import model.Coordinate;
import model.units.LongShip;
import model.units.Unit;


@Setter
@Getter
public class LongShipResponse extends AbstractUnitResponse {
    boolean isDead = false;
    boolean isHit = false;
    Coordinate attackCoordinate;

    public LongShipResponse() {
        super("LongShip");
    }

    @Override
    public AbstractUnitResponse getResponse(Unit unit, Coordinate attackCoordinate) {

        LongShip ship = (LongShip)unit;
        ship.setHealth(ship.getHealth() - 1);
        LongShipResponse longShipResponse = new LongShipResponse();
        longShipResponse.setAttackCoordinate(attackCoordinate);
        longShipResponse.setHit(true);
        longShipResponse.setShouldSwitchMovePlayer(true);

        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        longShipResponse.setMessage(ANSI_RED + "A ship got hit in (" + attackCoordinate.getX() + ", " +
                attackCoordinate.getY() + ")." + ANSI_RESET);

        if (ship.getHealth() == 0) {
            longShipResponse.setMessage(longShipResponse.getMessage() + "\nBy last hit on (" + attackCoordinate.getX() + ", " +
                    attackCoordinate.getY() + ") unit " + ship + "was destroyed.");
            longShipResponse.setDead(true);
        }

        return longShipResponse;
    }
}
