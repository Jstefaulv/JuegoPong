package cl.xdfw.pong.principal;

import cl.xdfw.pong.classes.Ventana;
import javax.swing.JFrame;

/**
 *
 * @author Jstefaulv
 */
public class Main {

    public static void main(String[] args) {
        Ventana vnt = new Ventana();
        vnt.setVisible(true);
        vnt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
