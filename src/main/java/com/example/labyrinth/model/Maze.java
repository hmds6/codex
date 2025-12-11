package com.example.labyrinth.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Core model storing the maze layout and player position.
 */
public class Maze {
    private final Cell[][] grid;
    private Position playerPosition;
    private final Position exitPosition;
    private final List<ModelObserver> observers = new ArrayList<>();

    public Maze(Cell[][] grid, Position start, Position exit) {
        this.grid = grid;
        this.playerPosition = start;
        this.exitPosition = exit;
    }

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        observers.forEach(ModelObserver::modelChanged);
    }

    public int rows() {
        return grid.length;
    }

    public int cols() {
        return grid[0].length;
    }

    public Cell cellAt(Position position) {
        return grid[position.row()][position.col()];
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public Position getExitPosition() {
        return exitPosition;
    }

    public boolean canMoveTo(Position target) {
        return isInside(target) && cellAt(target) != Cell.WALL;
    }

    public boolean movePlayer(Position target) {
        if (canMoveTo(target)) {
            playerPosition = target;
            notifyObservers();
            return true;
        }
        return false;
    }

    private boolean isInside(Position position) {
        return position.row() >= 0 && position.row() < grid.length
                && position.col() >= 0 && position.col() < grid[0].length;
    }

    public boolean isExitReached() {
        return playerPosition.equals(exitPosition);
    }
}
