import model.Board;
import model.TileType;

public class App {
    public static void main(String[] args) {
        Board b = new Board();

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(typeToChar(b.getTile(i, j).getType()));
            }
            System.out.println();
        }
    }

    public static String typeToChar(TileType type) {
            return switch (type) {
                case SEA -> " ";
                case LAND_PLAYER_1 -> "L";
                case LAND_PLAYER_2 -> "L";
                case LAND_NEUTRAL -> "+";
                case SEA_NEUTRAL -> "N";
            };
    }
}
