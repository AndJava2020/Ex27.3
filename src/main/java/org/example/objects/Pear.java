package org.example.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Pear extends Rectangle{
    private Rectangle pear;
    public Pear(){
        super(new Random().nextInt(290),new Random().nextInt(290),10,10);//размеры canvas
    }

    public void draw(GraphicsContext g){
        g.fillRect(super.getX(),super.getY(),super.getHeight(),super.getWidth());
    }

    public Rectangle getPear() {
        return pear;
    }

}
