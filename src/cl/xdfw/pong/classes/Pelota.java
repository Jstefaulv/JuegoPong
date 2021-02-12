
package cl.xdfw.pong.classes;

import java.applet.AudioClip;
import java.awt.geom.Rectangle2D;
import cl.xdfw.pong.resources.Audio;

/**
 *
 * @author Jstefaulv
 */

public class Pelota {
    private static final int t_x = 15;
    private static final int t_y = 15;
    private static double x = 0;
    private static double y = 0;
    private static double dx = 1;
    private static double dy = 1;
    
    //puntajes jugador1 - jugador2
    private Integer puntaje1 = 0, puntaje2 = 0;
    public static boolean gameOver = false;
    
    //sonidos dentro de juego
    Audio audio = new Audio();
    AudioClip racketBounce = audio.getAudio("/cl/xdfw/pong/sounds/RacketBounce.wav");
    AudioClip wallBounce = audio.getAudio("/cl/xdfw/pong/sounds/WallBounce.wav");
    AudioClip foul = audio.getAudio("/cl/xdfw/pong/sounds/Out.wav");
    AudioClip cont = audio.getAudio("/cl/xdfw/pong/sounds/Out.wav");
    
    public Rectangle2D getShape(){
        return new Rectangle2D.Double(x,y,t_x,t_y);
    }
    
    public void moverPelota(Rectangle2D limites,boolean colisionR1,boolean colisionR2){
        x += dx;
        y += dy;
        
        if(colisionR1){
            dx = -dx;
            x = 20;
            racketBounce.play();
        }
        if(colisionR2){
            dx = -dx;
            x = 755;
            racketBounce.play();
        }
        
        if(x < limites.getMinX()){
            puntaje2++;
            
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            foul.play();
        }
        
        if(x + t_x >= limites.getMaxX()){
            puntaje1++;
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            cont.play();
        }
        
        if(y < limites.getMinY()){
            y = limites.getMinY();
            dy= -dy;
            wallBounce.play();
        }
        if(y + t_y >= limites.getMaxY()){
            y = limites.getMaxY() - t_y;
            
            dy = -dy;
            wallBounce.play();
        }
    }
    
    public int getPuntaje1(){
        return puntaje1;
    }
    public int getPuntaje2(){
        return puntaje2;
    }
    
}
