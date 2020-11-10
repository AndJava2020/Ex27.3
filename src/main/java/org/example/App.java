package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    GameModel gameModel;
    ViewThread viewThread;
    GameController gameController;

    @Override
    public void start(Stage stage) throws IOException {
        gameModel=new GameModel(this);//гейм модель
        viewThread=new ViewThread(this); //гейм вью
        gameController=new GameController(this); //гейм контроллер

        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();

        Thread graphic=new Thread(viewThread);
        graphic.start();
    }

    private void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private  Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(gameController);
        return fxmlLoader.load();
    }

    private static void main(String[] args) {
        launch();
    }

}