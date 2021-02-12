package cl.xdfw.pong.classes;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Jstefaulv
 */
public class Racket {
    private int x,y;
    static final int ANCHO = 10, ALTO = 70;
    
    
    public Racket(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Rectangle2D getRacket(){
        return new Rectangle2D.Double(x,y,ANCHO,ALTO);
    }
    
    public void moverR1(Rectangle limites){
        if(Teclado.w && y > limites.getMinY()){
            y--;
        }
        if(Teclado.s && y < limites.getMaxY()){
            y++;
        }
    }
    public void moverR2(Rectangle limites){
        if(Teclado.up && y > limites.getMinY()){
            y--;
        }
        if(Teclado.down && y < limites.getMaxY()){
            y++;
        }
    }
    
    
}
