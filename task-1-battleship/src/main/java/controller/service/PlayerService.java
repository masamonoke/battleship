package controller.service;

import controller.PlayerData;
import controller.response.NullResponse;
import controller.response.ResponseReact;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import model.Coordinate;
import controller.response.AbstractUnitResponse;
import model.units.Unit;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerService {
    @Getter
    boolean shouldSwitchMovePlayer = false;

    public String makeMove(PlayerData playerData) {

        Coordinate attackCoordinate = chooseCoordinate(playerData.getNonAttackedCoordinates());

        AbstractUnitResponse response = enemyResponse(playerData.getOpponentData(), attackCoordinate);
        ResponseReact responseReact = new ResponseReact(playerData, response);
        shouldSwitchMovePlayer = responseReact.isShouldSwitchMovePlayer();
        return responseReact.getMessage();
    }

    private AbstractUnitResponse enemyResponse(PlayerData playerData, Coordinate attackCoordinate) {
        for (Unit unit : playerData.getUnits()) {
            if (UnitService.isUnitHit(unit, attackCoordinate)) {
                playerData.getUsedShipCoordinates().remove(attackCoordinate);
                return UnitService.getUnitResponse(unit, attackCoordinate);
            }
        }
        return new NullResponse("No unit being hit at coordinate" + attackCoordinate);
    }
    private Coordinate chooseCoordinate(List<Coordinate> playerCoordinates) {
        Coordinate attackCoordinate;
        if (playerCoordinates.size() == 1) {
            attackCoordinate = playerCoordinates.remove(0);
        } else {
            attackCoordinate = playerCoordinates
                    .remove(ThreadLocalRandom.current()
                            .nextInt(playerCoordinates.size() - 1));
        }
        return attackCoordinate;
    }


}
