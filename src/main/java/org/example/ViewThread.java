package org.example;

public class ViewThread implements Runnable{

    private GameView view;
    public ViewThread(App app){

        view=new GameView(app);
    }
    @Override
    public void run() {

        while(true) {
//            view.draw(gc, canvas, snake,pr);
              view.draw();
            try{
                Thread.sleep(150);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
    }
}
