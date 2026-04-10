package model;

public enum BattleResult {
    WIN,
    LOSE,
    LOSE_AND_DRAW, // When a mine is attacked, it is considered a loss, but both are removed
    DRAW // Remove both, as both were same type
}

