package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.App;
import org.example.objects.Pear;
import org.example.objects.Snake;

public class GameView {
    private App app;

    public GameView(App app){
        this.app=app;

    }
    public void draw(){
        app.gameModel.model();//запускаем бизнес логику

        GraphicsContext gc= app.gameController.getGc();
        Canvas canvas= app.gameController.getCanvas();
        Snake snake=app.gameModel.getSnake();
        Pear pear=app.gameModel.getPear();


        app.gameController.getGc().setFill(Color.ALICEBLUE);
        gc.fillRect(0,0,canvas.getHeight(),canvas.getWidth());
        gc.setFill(Color.BLACK);
        //gc.fillRect(rc.getX(),rc.getY(),rc.getHeight(),rc.getWidth()); //груша
        snake.draw(gc);
        gc.setFill(Color.RED);
        pear.draw(gc);


    }

}
