package com.example.labyrinth.command;

/**
 * Command abstraction for undoable operations.
 */
public interface Command {
    void execute();

    void undo();
}
