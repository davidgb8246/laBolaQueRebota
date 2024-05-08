package labolaquerebota.Modelo;

import javax.swing.JFrame;
import labolaquerebota.Modelo.Movimiento;
import labolaquerebota.Modelo.Punto;

/**
 *
 * @author david
 */
public class MovimientoRectilineo implements Movimiento {

    private Punto punto;
    private int vx, vy;
    
    public MovimientoRectilineo(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
    @Override
    public Punto desplazar(Punto punto, int size, JFrame frame) {
        this.punto = punto;
        
        if (this.punto.getPosX() > (frame.getWidth() - 12) - size || this.punto.getPosX() < 0) {
            vx *= -1;
        }

        if (this.punto.getPosY() > (frame.getHeight() - 12 - size * 2) || this.punto.getPosY() < 0) {
            vy *= -1;
        }

        if (this.punto.getPosX() > (frame.getWidth() - 12) - size) {
            this.punto.setPosX((frame.getWidth() - 12) - size);
        }

        if (this.punto.getPosX() < 0) {
            this.punto.setPosX(0);
        }

        if (this.punto.getPosY() > (frame.getHeight() - 12 - size * 2)) {
            this.punto.setPosY((frame.getHeight() - 12 - size * 2));
        }

        if (this.punto.getPosY() < 0) {
            this.punto.setPosY(0);
        }

        this.punto.setPosX(this.punto.getPosX() + vx);
        this.punto.setPosY(this.punto.getPosY() + vy);
        
        return this.punto;
    }
}