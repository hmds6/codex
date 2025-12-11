package com.example.labyrinth.view;

import com.example.labyrinth.controller.GameController;
import com.example.labyrinth.facade.GameFacade;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Contains player controls and undo/redo buttons.
 */
public class ControlPanel extends VBox {
    private final GameController controller;
    private final GameFacade facade;

    public ControlPanel(GameController controller, GameFacade facade) {
        super(8);
        this.controller = controller;
        this.facade = facade;
        setAlignment(Pos.TOP_CENTER);
        setPadding(new Insets(8));

        Button up = new Button("↑");
        Button down = new Button("↓");
        Button left = new Button("←");
        Button right = new Button("→");
        Button undo = new Button("Annuler");
        Button redo = new Button("Rétablir");

        up.setOnAction(e -> controller.moveUp());
        down.setOnAction(e -> controller.moveDown());
        left.setOnAction(e -> controller.moveLeft());
        right.setOnAction(e -> controller.moveRight());
        undo.setOnAction(e -> controller.undo());
        redo.setOnAction(e -> controller.redo());

        getChildren().addAll(up, down, left, right, undo, redo);
    }

    public void refresh() {
        // Buttons reflect invoker availability
        getChildren().stream()
                .filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .forEach(button -> {
                    if (button.getText().contains("Annuler")) {
                        button.setDisable(!facade.canUndo());
                    } else if (button.getText().contains("Rétablir")) {
                        button.setDisable(!facade.canRedo());
                    }
                });
    }
}
