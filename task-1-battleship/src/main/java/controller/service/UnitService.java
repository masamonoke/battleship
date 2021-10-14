package controller.service;

import controller.response.AbstractUnitResponse;
import controller.response.UnitResponseFactory;
import lombok.extern.slf4j.Slf4j;
import model.Coordinate;
import model.units.Unit;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
public class UnitService {

    public static boolean isUnitHit(Unit unit, Coordinate attackCoordinate) {

        return isUnitGotHit(unit.getStartCoordinate(), unit.getEndCoordinate(), attackCoordinate);
    }

    public static AbstractUnitResponse getUnitResponse(Unit unit, Coordinate attackCoordinate) {

        UnitResponseFactory unitResponseFactory = new UnitResponseFactory();
        AbstractUnitResponse abstractUnitResponse = unitResponseFactory.defineResponse(unit);

        return abstractUnitResponse.getResponse(unit, attackCoordinate);
    }


    protected static boolean isUnitGotHit(Coordinate startCoordinate, Coordinate endCoordinate, Coordinate attackCoordinate) {
        if (startCoordinate == endCoordinate) {
            return startCoordinate == attackCoordinate;
        }

        if (startCoordinate.getX() == endCoordinate.getX() && startCoordinate.getX() == attackCoordinate.getX()) {
            return isBetween(startCoordinate.getY(), endCoordinate.getY(), attackCoordinate.getY());
        } else if (startCoordinate.getY() == endCoordinate.getY() && startCoordinate.getY() == attackCoordinate.getY()) {
            return isBetween(startCoordinate.getX(), endCoordinate.getX(), attackCoordinate.getX());
        }
        return false;
    }
    private static boolean isBetween(int v1, int v2, int value) {
        if (v1 < v2) {
            return value >= v1 && value <= v2;
        } else {
            return value >= v2 && value <= v1;
        }
    }

    public static Set<Coordinate> defineUsedCoordinates(Coordinate startCoordinate, Coordinate endCoordinate) {
        Set<Coordinate> usedCoordinates = new LinkedHashSet<>();
        if (startCoordinate.getX() == endCoordinate.getX()) {
            int x = startCoordinate.getX();
            int start = Math.min(startCoordinate.getY(), endCoordinate.getY());
            int end = Math.max(startCoordinate.getY(), endCoordinate.getY());
            for (int i = start; i <= end; i++) {
                usedCoordinates.add(new Coordinate(x, i));
            }
        } else if (startCoordinate.getY() == endCoordinate.getY()) {
            int y = startCoordinate.getY();
            int start = Math.min(startCoordinate.getX(), endCoordinate.getX());
            int end = Math.max(startCoordinate.getX(), endCoordinate.getX());
            for (int i = start; i <= end; i++) {
                usedCoordinates.add(new Coordinate(i, y));
            }
        }

        return usedCoordinates;
    }

}
