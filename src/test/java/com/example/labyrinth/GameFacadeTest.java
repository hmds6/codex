package com.example.labyrinth;

import com.example.labyrinth.command.Invoker;
import com.example.labyrinth.facade.GameFacade;
import com.example.labyrinth.model.Maze;
import com.example.labyrinth.model.MazeFactory;
import com.example.labyrinth.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameFacadeTest {

    @Test
    void playerMovesAndUndoRedoWork() {
        Maze maze = MazeFactory.demoMaze();
        GameFacade facade = new GameFacade(maze, new Invoker());

        Position start = facade.playerPosition();
        facade.move(0, 1);
        assertNotEquals(start, facade.playerPosition());

        facade.undo();
        assertEquals(start, facade.playerPosition());

        facade.redo();
        assertNotEquals(start, facade.playerPosition());
    }

    @Test
    void cannotWalkThroughWalls() {
        Maze maze = MazeFactory.demoMaze();
        GameFacade facade = new GameFacade(maze, new Invoker());

        Position start = facade.playerPosition();
        facade.move(-1, 0); // wall
        assertEquals(start, facade.playerPosition());
    }
}
