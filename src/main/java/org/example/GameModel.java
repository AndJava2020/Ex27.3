package org.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.example.App;
import org.example.objects.Pear;
import org.example.objects.Snake;

import java.util.Random;

public class GameModel {
    private Snake snake;
    private Pear pear;

    public Snake getSnake() {
        return snake;
    }
    public Pear getPear() {
        return pear;
    }

    private App app;
    public GameModel(App app){
        this.app=app;
        snake=new Snake();
        pear=new Pear();
    }


    public void model(){
        if(snake.collisionTail()) snake=new Snake();
        if(snake.eatPear(pear)) pear=new Pear();

            snake.toToward();
            snake.edge(app.gameController.getCanvas().getHeight(),app.gameController.getCanvas().getWidth());


    }
}
