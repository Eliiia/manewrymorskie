package model;

/*
 * The type of ship this is.
 * This could be called `ShipType`, but since we don't need a ship container,
 * calling it `Ship` is just cleaner.
 */
public class Ship {
    private final ShipType type;
    private Tile position; // or x,y
    private Player owner;

    public Ship(ShipType type, Player owner) {
        this.type = type;
        this.owner = owner;
    }

    public int getMovement() {
        return type.getMaxMovement();
    }

    public int getAttackRange() {
        return type.getAttackRange();
    }

    public ShipType getType() {
        return type;
    }

    public Player getOwner() {
        return owner;
    }
}
