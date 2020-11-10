package org.example.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;//Сделать спавн змейки нормальный, голову подстветить, генерацию поправить + стенки

//
//class partOfBody extends Rectangle {
//        public void rec(){
//
//        }
//
//        }
public class Snake {
    private partOfBody head;
    private partOfBody tail;
    private int step=5;
    private int width=20;
    private int height=20;
    private ArrayList<partOfBody> parts;
    private toSide history=toSide.RIGHT;

    enum side{
        LEFT,RIGHT,UP,DOWN
    }

    private class partOfBody extends  Rectangle{//координаты хвоста присваиваются координатам головы и  смещаем взависимости от команды
        partOfBody(double x, double y){
            super(x,y,width,width);
        }
    }
    public Snake(){
        parts=new ArrayList<>();
        head=new partOfBody(50,50);
        parts.add(head);
        tail=new partOfBody(head.getX()+width,head.getY());
        parts.add(tail);

    }
    public void setSide(toSide e){
        if(!checkSide(e))
            history=e;
    }
    private boolean checkSide(toSide e){
        if(e==toSide.LEFT && history==toSide.RIGHT || e==toSide.RIGHT && history==toSide.LEFT ) return  true;
        if(e==toSide.DOWN && history==toSide.UP|| e==toSide.UP && history==toSide.DOWN ) return  true;
        return false;

    }

    public void toToward(){

        //шаг змейки
        switch (history){
            case LEFT:
                tail.setX(head.getX()-width);
                tail.setY(head.getY());
                break;
            case RIGHT:
                tail.setX(head.getX()+width);
                tail.setY(head.getY());
                break;
            case UP:
                tail.setX(head.getX());
                tail.setY(head.getY()-width);
                break;
            case DOWN:
                tail.setX(head.getX());
                tail.setY(head.getY()+width);
                break;
        }

        head=tail;

        parts.remove(parts.size()-1);
        parts.add(0,head);
        tail=parts.get(parts.size()-1);

    }
    private void addPart(){
            partOfBody temp=new partOfBody(tail.getX()+width,tail.getY());
            parts.add(temp);
            tail=temp;
    }

    public void draw(GraphicsContext g){//вынести в gameview
        g.setFill(Color.SPRINGGREEN);
            for (partOfBody temp:parts
             ) {
            g.fillRect(temp.getX(),temp.getY(),width,width);
        }
              g.setFill(Color.SILVER);
              g.fillRect(head.getX(),head.getY(),width,width);


    }

    public boolean eatPear(Rectangle g){
        Shape shape=Shape.intersect(head,g);
        if(shape.getBoundsInLocal().getWidth()!= -1){
            addPart();
            System.out.println("ням");
            return true;
        }
        return  false;
    }
    public boolean collisionTail(){
        for (int i = 2; i <  parts.size(); i++)
        if(Shape.intersect(head,parts.get(i)).getBoundsInLocal().getWidth()!= -1){
            System.out.println("Врезались");
            return true;
        }
        return  false;
    }

}
