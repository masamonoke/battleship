package model.units.types;

public enum ShipType {
    Lil(1),
    Destroyer(2),
    Cruiser(3),
    Battleship(4),
    Carrier(5);

    private final int value;

    ShipType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
