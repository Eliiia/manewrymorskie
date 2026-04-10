package model;

/*
 * A tile; detailing one part of the map!
 */
public class Tile {
    /* What kind of tile is this? */
    private final TileType type;

    /* In which direction(s) do walls exist */
    private final Direction[] walls;

    public Tile(TileType type, Direction[] walls) {
        this.type = type;
        this.walls = walls;
    }

    public TileType getType() {
        return type;
    }
}