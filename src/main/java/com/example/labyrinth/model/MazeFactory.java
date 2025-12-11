package com.example.labyrinth.model;

/**
 * Builds predefined mazes to keep the UI decoupled from layout details.
 */
public final class MazeFactory {
    private MazeFactory() {
    }

    public static Maze demoMaze() {
        Cell P = Cell.PATH;
        Cell W = Cell.WALL;
        Cell E = Cell.EXIT;
        Cell[][] grid = {
                {W, W, W, W, W, W, W},
                {W, P, P, P, W, P, W},
                {W, P, W, P, P, P, W},
                {W, P, W, W, W, P, W},
                {W, P, P, P, P, P, W},
                {W, W, W, P, W, P, W},
                {W, P, P, P, W, E, W},
                {W, W, W, W, W, W, W}
        };
        return new Maze(grid, new Position(1, 1), new Position(6, 5));
    }
}
