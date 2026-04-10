package model;

/**
 * Represents a generic game board!
 */
public class Board {
    /* Only one board size is ever accepted */
    private static final int WIDTH = 12;
    private static final int LENGTH = 18;

    /* Board is 12 wide, 18 long */
    private Tile[][] tiles = new Tile[LENGTH][WIDTH];

    public Board() {
        // Hardcode board!
        String[] layout = new String[] {
            "222222222222",
            "222222222222",
            "22SSSSS22222",
            "SSSSSSS22222",
            "SSSSSSSSSSSS",
            "SSSSSSSSSSSS",
            "SSSSSsSSSSSS",
            "SSSSSsssSSSS",
            "SSSSsNNsSSSS",
            "SSSSsNNsSSSS",
            "SSSSsssSSSSS",
            "SSSSSSsSSSSS",
            "SSSSSSSSSSSS",
            "SSSSSSSSSSSS",
            "11111SSSSSSS",
            "11111SSSSS11",
            "111111111111",
            "111111111111"
        };

        // Read string-hardcoded board and load :)
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < WIDTH; y++) {
                char c = layout[x].charAt(y);
                switch (c) {
                    case '1': tiles[x][y] = new Tile(TileType.LAND_PLAYER_1, new Direction[]{}); break;
                    case '2': tiles[x][y] = new Tile(TileType.LAND_PLAYER_2, new Direction[]{}); break;
                    case 'S': tiles[x][y] = new Tile(TileType.SEA, new Direction[]{}); break;
                    case 'N': tiles[x][y] = new Tile(TileType.LAND_NEUTRAL, new Direction[]{}); break;
                    case 's': tiles[x][y] = new Tile(TileType.SEA_NEUTRAL, new Direction[]{}); break;
                }
            }
        }
    }

    public Tile getTile(int x, int y) {
        return this.tiles[x][y];
    }
}
