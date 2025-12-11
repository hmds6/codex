package com.example.labyrinth.view;

import com.example.labyrinth.facade.GameFacade;
import com.example.labyrinth.model.Cell;
import com.example.labyrinth.model.Position;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Displays the maze grid.
 */
public class MazeView extends GridPane {
    private final GameFacade facade;

    public MazeView(GameFacade facade) {
        this.facade = facade;
        setAlignment(Pos.CENTER);
        setHgap(4);
        setVgap(4);
    }

    public void refresh() {
        getChildren().clear();
        for (int row = 0; row < facade.rows(); row++) {
            for (int col = 0; col < facade.cols(); col++) {
                Position position = new Position(row, col);
                Rectangle cell = buildCell(position);
                add(cell, col, row);
            }
        }
    }

    private Rectangle buildCell(Position position) {
        Cell cell = facade.cellAt(position);
        Rectangle rectangle = new Rectangle(40, 40);
        rectangle.setArcWidth(8);
        rectangle.setArcHeight(8);

        if (position.equals(facade.playerPosition())) {
            rectangle.setFill(Color.CORNFLOWERBLUE);
        } else if (cell == Cell.EXIT) {
            rectangle.setFill(Color.LIGHTGREEN);
        } else if (cell == Cell.WALL) {
            rectangle.setFill(Color.DARKSLATEGRAY);
        } else {
            rectangle.setFill(Color.BEIGE);
        }
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }
}
