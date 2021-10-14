package controller;

import controller.service.UnitService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import model.Board;
import model.Coordinate;
import model.Player;
import model.units.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlayerData {
    Player player;
    @NonFinal @Setter
    PlayerData opponentData;
    Set<Unit> units;
    List<Coordinate> usedShipCoordinates = new ArrayList<>();
    List<Coordinate> nonAttackedCoordinates;
    Set<Coordinate> minesCoordinates = new LinkedHashSet<>();
    Set<Coordinate> exposedOpponentCoordinates = new LinkedHashSet<>();

    public PlayerData(Player player, Set<Unit> units, Board board) {
        this.player = player;
        this.units = units;
        fillUsedCoordinatesAndMines(units);
        nonAttackedCoordinates = fillNonAttackedCoordinates(board);
    }

    private void fillUsedCoordinatesAndMines(Set<Unit> units) {

        for (Unit unit : units) {
            if (unit instanceof LongShip) {

                usedShipCoordinates.addAll(UnitService.defineUsedCoordinates(((LongShip)unit).getStartCoordinate(), ((LongShip)unit).getEndCoordinate()));

            } else if (unit instanceof OneSquareUnit) {

                usedShipCoordinates.add(((OneSquareUnit) unit).getCoordinate());

            }
        }
    }
    private List<Coordinate> fillNonAttackedCoordinates(Board board) {
        List<Coordinate> coordinates = new ArrayList<>();
        int i = 1, j = 1;
        while (i <= board.getXLimit()) {
            j = 1;
            while (j <= board.getYLimit()) {
                coordinates.add(new Coordinate(i, j));
                j++;
            }
            i++;
        }
        return coordinates;
    }
}
