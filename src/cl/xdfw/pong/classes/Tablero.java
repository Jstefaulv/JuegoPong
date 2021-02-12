package cl.xdfw.pong.classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 *
 * @author Jstefaulv
 */
public class Tablero extends JPanel {

    Racket r1 = new Racket(10, 200);
    Racket r2 = new Racket(794 - 10 - Racket.ANCHO, 200);
    Pelota p = new Pelota();

    public Tablero() {
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.PINK);
        dibujar(g2d);
        dibujarPuntaje(g2d);
    }

    private void dibujar(Graphics2D g) {
        Line2D.Double linea = new Line2D.Double(
                getBounds().
                        getCenterX(),
                0, getBounds().getCenterX(),
                getBounds().getMaxY());
        g.draw(linea);
        
        g.fill(r1.getRacket());
        update();
        
        g.fill(r2.getRacket());
        update();
        
        g.fill(p.getShape());
        update();

    }

    private void update() {
        p.moverPelota(getBounds(),
                colision(r1.getRacket()),
                colision(r2.getRacket()));
        
        r1.moverR1(getBounds());
        r2.moverR2(getBounds());
    }

    private boolean colision(Rectangle2D r) {
        return p.getShape().intersects(r);
    }

    private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        Font puntaje = new Font("Agency FB", Font.BOLD, 35);
        g.setFont(puntaje);
        

        g1.drawString(Integer.toString(p.getPuntaje1()),
                (float) getBounds().getCenterX() - 40, 30);
        g2.drawString(Integer.toString(p.getPuntaje2()),
                (float) getBounds().getCenterX() + 25, 30);
        if (p.getPuntaje1() == 7) {
            g.drawString("JUGADOR1 GANA",
                    (float) getBounds().getCenterX() - 95,
                    (float) getBounds().getCenterY() - 100);
            Pelota.gameOver = true;
        }
        if (p.getPuntaje2() == 7) {
            g.drawString("JUGADOR2 GANA",
                    (float) getBounds().getCenterX() - 95,
                    (float) getBounds().getCenterY() - 100);
            Pelota.gameOver = true;
        }
    }
}
