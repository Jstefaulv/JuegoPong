
package cl.xdfw.pong.classes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jstefaulv
 */
public class Teclado extends KeyAdapter{
    static boolean w,s,up,down;
    /**
     * Cuando se presiona alguna de las teclas como W-S (Jugador1) o
     * teclas de dirección Up-Down (Jugador2) se gatilla un evento que
     * detecta las teclas presionadas.
     * 
     * @param evt objeto desde KeyEvent que recibe las teclas presionadas
     * para determinar una acción dentro del juego.
     */
    @Override
    public void keyPressed(KeyEvent evt){
        int id= evt.getKeyCode();
        
        if(id == KeyEvent.VK_W){
            w = true;
        }
        if(id == KeyEvent.VK_S){
            s = true;
        }
        if(id == KeyEvent.VK_UP){
            up = true;
        }
        if(id == KeyEvent.VK_DOWN){
            down = true;
        }
    }
    
    /**
     * Acción que se gatilla cuando se dejan de presionar las teclas.
     * (se sueltan)
     * @param evt se gatilla cada vez que se deja de presionar la tecla,
     * para que deje de realizar movimiento dentro del tablero de juego.
     */
    @Override
    public void keyReleased(KeyEvent evt){
         int id = evt.getKeyCode();
        if (id == KeyEvent.VK_W) {
            w = false;
        }
        if (id == KeyEvent.VK_S) {
            s = false;
        }
        if (id == KeyEvent.VK_UP) {
            up = false;
        }
        if (id == KeyEvent.VK_DOWN) {
            down = false;
        }
    }
}
