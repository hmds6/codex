package com.example.labyrinth.facade;

import com.example.labyrinth.command.Invoker;
import com.example.labyrinth.command.MoveCommand;
import com.example.labyrinth.model.Cell;
import com.example.labyrinth.model.Maze;
import com.example.labyrinth.model.ModelObserver;
import com.example.labyrinth.model.Position;

/**
 * Facade exposing only safe operations to the UI and controllers.
 */
public class GameFacade {
    private final Maze maze;
    private final Invoker invoker;

    public GameFacade(Maze maze, Invoker invoker) {
        this.maze = maze;
        this.invoker = invoker;
    }

    public void addObserver(ModelObserver observer) {
        maze.addObserver(observer);
    }

    public Cell cellAt(Position position) {
        return maze.cellAt(position);
    }

    public Position playerPosition() {
        return maze.getPlayerPosition();
    }

    public Position exitPosition() {
        return maze.getExitPosition();
    }

    public int rows() {
        return maze.rows();
    }

    public int cols() {
        return maze.cols();
    }

    public void move(int dRow, int dCol) {
        Position target = maze.getPlayerPosition().translate(dRow, dCol);
        invoker.execute(new MoveCommand(maze, target));
    }

    public void undo() {
        invoker.undo();
    }

    public void redo() {
        invoker.redo();
    }

    public boolean canUndo() {
        return invoker.canUndo();
    }

    public boolean canRedo() {
        return invoker.canRedo();
    }

    public boolean hasWon() {
        return maze.isExitReached();
    }
}
