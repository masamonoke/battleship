package controller.service;

import model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitServiceTest {

    @Test
    void isShipGotHitTest1() {
        Coordinate startCoordinate = new Coordinate(4, 1);
        Coordinate endCoordinate = new Coordinate(4,3);
        Coordinate attackCoordinate = new Coordinate(4, 2);
        assertTrue(UnitService.isUnitGotHit(startCoordinate, endCoordinate, attackCoordinate));
    }

    @Test
    void isShipGotHitTest2() {
        Coordinate startCoordinate = new Coordinate(4, 1);
        Coordinate endCoordinate = new Coordinate(4,3);
        Coordinate attackCoordinate = new Coordinate(4, 1);
        assertTrue(UnitService.isUnitGotHit(startCoordinate, endCoordinate, attackCoordinate));
    }

    @Test
    void isShipGotHitTest3() {
        Coordinate startCoordinate = new Coordinate(4, 1);
        Coordinate endCoordinate = new Coordinate(4,3);
        Coordinate attackCoordinate = new Coordinate(4, 3);
        assertTrue(UnitService.isUnitGotHit(startCoordinate, endCoordinate, attackCoordinate));
    }

    @Test
    void isShipGotHitTest4() {
        Coordinate startCoordinate = new Coordinate(4, 1);
        Coordinate endCoordinate = new Coordinate(4,3);
        Coordinate attackCoordinate = new Coordinate(4, 4);
        assertFalse(UnitService.isUnitGotHit(startCoordinate, endCoordinate, attackCoordinate));
    }

    @Test
    void isShipGotHitTest5() {
        Coordinate startCoordinate = new Coordinate(4, 1);
        Coordinate endCoordinate = new Coordinate(4,3);
        Coordinate attackCoordinate = new Coordinate(0, 0);
        assertFalse(UnitService.isUnitGotHit(startCoordinate, endCoordinate, attackCoordinate));
    }
}