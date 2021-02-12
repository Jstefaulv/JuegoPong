
package cl.xdfw.pong.resources;

import cl.xdfw.pong.classes.Pelota;
import cl.xdfw.pong.classes.Tablero;

/**
 *
 * @author Jstefaulv
 */
public class Graficos extends Thread{
    private final Tablero canvas;
    
    public Graficos(Tablero canvas){
        this.canvas = canvas;
    }
    
    @Override
    public void run(){
        while(!Pelota.gameOver){
            canvas.repaint();
            
            try{
                Thread.sleep(6);
            }catch(Exception ex){
                System.out.println("Error :"+ex);
            }
        }
    }
}
