package com.example.labyrinth.view;

import com.example.labyrinth.facade.GameFacade;
import com.example.labyrinth.model.Position;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Displays current player position and win message.
 */
public class StatusBar extends HBox {
    private final Label positionLabel = new Label();
    private final Label stateLabel = new Label();
    private final GameFacade facade;

    public StatusBar(GameFacade facade) {
        this.facade = facade;
        setPadding(new Insets(8));
        setSpacing(12);
        setAlignment(Pos.CENTER_LEFT);
        getChildren().addAll(positionLabel, stateLabel);
        refresh();
    }

    public void refresh() {
        Position position = facade.playerPosition();
        positionLabel.setText("Position : " + position);
        if (facade.hasWon()) {
            stateLabel.setText("Bravo ! Sortie trouvée.");
        } else {
            Position exit = facade.exitPosition();
            stateLabel.setText("Sortie en " + exit);
        }
    }
}
