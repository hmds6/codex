package com.example.labyrinth.view;

import com.example.labyrinth.controller.GameController;
import com.example.labyrinth.facade.GameFacade;
import com.example.labyrinth.model.ModelObserver;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

/**
 * Root view containing maze grid, controls and status.
 */
public class GameView extends BorderPane implements ModelObserver {
    private final MazeView mazeView;
    private final StatusBar statusBar;
    private final ControlPanel controlPanel;
    private final GameFacade facade;
    private final GameController controller;

    public GameView(GameFacade facade, GameController controller) {
        this.facade = facade;
        this.controller = controller;
        this.mazeView = new MazeView(facade);
        this.statusBar = new StatusBar(facade);
        this.controlPanel = new ControlPanel(controller, facade);

        setPadding(new Insets(10));
        setCenter(mazeView);
        setBottom(statusBar);
        setRight(controlPanel);

        facade.addObserver(this);

        setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.UP) controller.moveUp();
            else if (code == KeyCode.DOWN) controller.moveDown();
            else if (code == KeyCode.LEFT) controller.moveLeft();
            else if (code == KeyCode.RIGHT) controller.moveRight();
            else if (code == KeyCode.Z && event.isControlDown()) controller.undo();
            else if (code == KeyCode.Y && event.isControlDown()) controller.redo();
        });

        refresh();
    }

    private void refresh() {
        mazeView.refresh();
        statusBar.refresh();
    }

    @Override
    public void modelChanged() {
        refresh();
    }
}
