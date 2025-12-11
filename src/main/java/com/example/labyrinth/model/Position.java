package com.example.labyrinth.model;

import java.util.Objects;

/**
 * Immutable coordinate inside the maze grid.
 */
public record Position(int row, int col) {
    public Position translate(int dRow, int dCol) {
        return new Position(row + dRow, col + dCol);
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position other)) return false;
        return row == other.row && col == other.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
