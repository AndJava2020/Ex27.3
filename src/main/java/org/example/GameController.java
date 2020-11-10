package org.example;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.App;
import org.example.objects.Pear;
import org.example.objects.Snake;
import org.example.objects.toSide;

public class GameController {

    @FXML private Canvas canvas ;
    private GraphicsContext gc ;
    @FXML private Button btn;

    @FXML
    private VBox vbox;

    private App app;
    public GameController(App app){
        this.app=app;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Canvas getCanvas() {
        return canvas;
    }



    @FXML
    public void initialize(){
        gc= canvas.getGraphicsContext2D();

        canvas.setHeight(300);
        canvas.setWidth(300);
        gc.setFill(Color.ALICEBLUE);
        gc.fillRect(0,0,canvas.getHeight(),canvas.getWidth());//фон


       // model.main(gc,canvas,snake,pr);
        vbox.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.D) app.gameModel.getSnake().setSide(toSide.RIGHT);
                if(keyEvent.getCode()== KeyCode.W) app.gameModel.getSnake().setSide(toSide.UP);
                if(keyEvent.getCode()== KeyCode.A) app.gameModel.getSnake().setSide(toSide.LEFT);
                if(keyEvent.getCode()== KeyCode.S) app.gameModel.getSnake().setSide(toSide.DOWN);
            }
        });


//        btn.setOnAction(actionEvent -> {
//            if(snake.peresechenie(rc)) System.out.println("ЕСТЬ!");
//            gc.setFill(Color.ALICEBLUE);
//            gc.fillRect(0,0,canvas.getHeight(),canvas.getWidth());
//            gc.setFill(Color.BLACK);
//            gc.fillRect(rc.getX(),rc.getY(),rc.getHeight(),rc.getWidth());
//            snake.draw(gc);
//            System.out.println("color set to black");
//        });

    }

}
