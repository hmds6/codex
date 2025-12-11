package com.example.labyrinth.controller;

import com.example.labyrinth.facade.GameFacade;

/**
 * Thin controller that delegates to the facade.
 */
public class GameController {
    private final GameFacade facade;

    public GameController(GameFacade facade) {
        this.facade = facade;
    }

    public void moveUp() {
        facade.move(-1, 0);
    }

    public void moveDown() {
        facade.move(1, 0);
    }

    public void moveLeft() {
        facade.move(0, -1);
    }

    public void moveRight() {
        facade.move(0, 1);
    }

    public void undo() {
        facade.undo();
    }

    public void redo() {
        facade.redo();
    }
}
