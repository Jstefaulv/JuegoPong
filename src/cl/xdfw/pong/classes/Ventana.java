package cl.xdfw.pong.classes;

import javax.swing.JFrame;
import cl.xdfw.pong.resources.Graficos;

/**
 *
 * @author Jstefaulv
 */
public class Ventana extends JFrame {
    Tablero t = new Tablero();
    Pelota p = new Pelota();
    
    public Ventana(){
        setTitle("Pong - Java");
        setSize(800,500);
        setLocationRelativeTo(this);
        setResizable(false);        
        add(t);
        addKeyListener(new Teclado());
        new Graficos(t).start();
    }
}
