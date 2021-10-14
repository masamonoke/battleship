package controller.response;

import controller.PlayerData;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import model.Coordinate;

import java.util.concurrent.ThreadLocalRandom;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseReact {

    @Getter
    boolean shouldSwitchMovePlayer = true;
    @Getter
    String message;

    public ResponseReact(PlayerData currentPlayerData, AbstractUnitResponse enemyAbstractUnitResponse) {

        shouldSwitchMovePlayer = enemyAbstractUnitResponse.isShouldSwitchMovePlayer();
        message = enemyAbstractUnitResponse.getMessage();

        //TODO rid of instances check with factory
        /*if (enemyAbstractUnitResponse instanceof LongShipResponse) {
            shouldSwitchMovePlayer = false;
            message = enemyAbstractUnitResponse.getMessage();
        }
        else if (enemyAbstractUnitResponse instanceof MineResponse) {
            currentPlayerData.getExposedOpponentCoordinates().add(exposeRandomUsedCoordinate(currentPlayerData.getOpponentData()));
            shouldSwitchMovePlayer = true;
            message = enemyAbstractUnitResponse.getMessage();
        } else if (enemyAbstractUnitResponse instanceof MinesweeperResponse) {
            //minesweeper response logic
        }
        else if (enemyAbstractUnitResponse instanceof NullResponse) {
            message = enemyAbstractUnitResponse.getMessage();
        }*/
    }

    private Coordinate exposeRandomUsedCoordinate(PlayerData playerData) {
        return playerData.getUsedShipCoordinates().remove(ThreadLocalRandom.current().nextInt(playerData.getUsedShipCoordinates().size() - 1));
    }
}
