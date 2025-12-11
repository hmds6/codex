package com.example.labyrinth.view;

import com.example.labyrinth.command.Invoker;
import com.example.labyrinth.controller.GameController;
import com.example.labyrinth.facade.GameFacade;
import com.example.labyrinth.model.Maze;
import com.example.labyrinth.model.MazeFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX entry point assembling MVC pieces.
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Maze maze = MazeFactory.demoMaze();
        GameFacade facade = new GameFacade(maze, new Invoker());
        GameController controller = new GameController(facade);

        GameView root = new GameView(facade, controller);
        Scene scene = new Scene(root, 640, 480);

        primaryStage.setTitle("Labyrinthe MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
