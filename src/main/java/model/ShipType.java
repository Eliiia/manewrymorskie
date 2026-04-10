package model;

/**
 * Enum representing all possible ship types, with English/Polish names and movement per turn.
 */
public enum ShipType {
    BATTLESHIP("Battleship", "Pancernik", 2),
    ROCKET("Rocket Ship", "Okręt rakietowy", 1),
    CRUISER("Cruiser", "Krążownik", 2),
    DESTROYER("Destroyer", "Niszczyciel", 4),
    SUBMARINE("Submarine", "Okręt podwodny", 2),
    ESCORTER("Escorter", "Eskortowiec", 3),
    MINESWEEPER("Minesweeper", "Trałowiec", 2),
    LANDING("Landing Ship", "Okręt desantowy", 1),
    COASTAL("Coastal Artillery", "Bateria nabrzeżna", 0),
    MINE("Mine", "Mina", 0);

    private final String name_en;
    private final String name_pl;
    private final int maxMovement;

    ShipType(String name_en, String name_pl, int maxMovement) {
        this.name_en = name_en;
        this.name_pl = name_pl;
        this.maxMovement = maxMovement;
    }

    public String getName_en() {
        return name_en;
    }

    public String getName_pl() {
        return name_pl;
    }

    public int getMaxMovement() {
        return maxMovement;
    }

    public int getAttackRange() {
        if (this == COASTAL) return 1;
        if (this == LANDING) return 0;
        else return maxMovement;
    }

    /**
     * Determines the result of this ship type attacking another.
     * @param other the opposing ship type
     * @return WIN if this type wins, LOSE if loses, DRAW if both are removed
     */
    public BattleResult winsIfAttacks(ShipType other) {
        // If both are the same, it is a draw!
        if (this == other) return BattleResult.DRAW;
        // If attacking coastal artillery or a mine, always lose
        if (other == COASTAL) return BattleResult.LOSE;
        if (other == MINE) return BattleResult.LOSE_AND_DRAW; // remove both

        return switch (this) {
            // Battleship wins against all but submarine
            case BATTLESHIP -> other == SUBMARINE ? BattleResult.LOSE : BattleResult.WIN;
            // Rocketship wins against all but battleship and submarine
            case ROCKET -> (other == BATTLESHIP || other == SUBMARINE) ? BattleResult.LOSE : BattleResult.WIN;
            // Cruiser wins against all but battleship, rocketship, and submarine
            case CRUISER ->
                    (other == BATTLESHIP || other == ROCKET || other == SUBMARINE) ? BattleResult.LOSE : BattleResult.WIN;
            // Destroyer wins against all but battleship, rocketship, and cruiser
            case DESTROYER ->
                    (other == BATTLESHIP || other == ROCKET || other == CRUISER) ? BattleResult.LOSE : BattleResult.WIN;
            // Submarine wins against all but escorter.
            case SUBMARINE -> other == ESCORTER ? BattleResult.LOSE : BattleResult.WIN;
            // Escorter wins against all but submarine and minesweeper
            case ESCORTER -> (other != SUBMARINE && other != MINESWEEPER) ? BattleResult.LOSE : BattleResult.WIN;
            // Minesweeper loses against everyone
            case MINESWEEPER -> BattleResult.LOSE;
            // Landing ship loses to everything
            case LANDING -> BattleResult.LOSE;
            // Coastal artillery wins against all but rocket ship
            case COASTAL -> (other != ROCKET) ? BattleResult.LOSE : BattleResult.WIN;
            // Mine wins against all (this is for attack logic, not minesweeping logic)
            case MINE -> BattleResult.WIN;
        };
    }
}
