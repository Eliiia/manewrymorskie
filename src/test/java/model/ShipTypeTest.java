package model;

import static org.junit.jupiter.api.Assertions.*;

class ShipTypeTest {

    @org.junit.jupiter.api.Test
    void testWinsIfAttacks() {
        // Just testing some specific niche-cases, and assuming the rest of the logic is ok!

        // Battleship should win against Cruiser
        assertEquals(BattleResult.WIN, ShipType.BATTLESHIP.winsIfAttacks(ShipType.CRUISER));
        assertEquals(BattleResult.LOSE, ShipType.CRUISER.winsIfAttacks(ShipType.BATTLESHIP));
        // Battleship should lose against Submarine
        assertEquals(BattleResult.WIN, ShipType.SUBMARINE.winsIfAttacks(ShipType.BATTLESHIP));
        assertEquals(BattleResult.LOSE, ShipType.BATTLESHIP.winsIfAttacks(ShipType.SUBMARINE));

        // Minesweeper loses against mine (it is not a "remove mine" action)
        assertEquals(BattleResult.LOSE_AND_DRAW, ShipType.MINESWEEPER.winsIfAttacks(ShipType.MINE));
        // Everyone loses against mine
        assertEquals(BattleResult.LOSE_AND_DRAW, ShipType.SUBMARINE.winsIfAttacks(ShipType.MINE));
        // Minesweeper also loses against everyone else; e.g. escorter
        assertEquals(BattleResult.LOSE, ShipType.MINESWEEPER.winsIfAttacks(ShipType.ESCORTER));
        assertEquals(BattleResult.WIN, ShipType.ESCORTER.winsIfAttacks(ShipType.MINESWEEPER));

        // With destroyer x submarine, the one to attack first wins
        assertEquals(BattleResult.WIN, ShipType.DESTROYER.winsIfAttacks(ShipType.SUBMARINE));
        assertEquals(BattleResult.WIN, ShipType.SUBMARINE.winsIfAttacks(ShipType.DESTROYER));
    }

}