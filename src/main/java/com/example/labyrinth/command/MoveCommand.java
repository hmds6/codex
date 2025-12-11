package com.example.labyrinth.command;

import com.example.labyrinth.model.Maze;
import com.example.labyrinth.model.Position;

/**
 * Command to move the player inside the maze.
 */
public class MoveCommand implements Command {
    private final Maze maze;
    private final Position from;
    private final Position to;
    private boolean executed;

    public MoveCommand(Maze maze, Position to) {
        this.maze = maze;
        this.from = maze.getPlayerPosition();
        this.to = to;
    }

    @Override
    public void execute() {
        if (!executed && maze.movePlayer(to)) {
            executed = true;
        }
    }

    @Override
    public void undo() {
        if (executed) {
            maze.movePlayer(from);
            executed = false;
        }
    }
}
