package labolaquerebota.Modelo;

import javax.swing.JFrame;
import labolaquerebota.Modelo.Movimiento;
import labolaquerebota.Modelo.Punto;

/**
 *
 * @author david
 */
public class MovimientoCircularUniforme implements Movimiento {

    private Punto punto;
    private int vx, vy;
    
    public MovimientoCircularUniforme(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
    @Override
    public Punto desplazar(Punto punto, int size, JFrame frame) {
        this.punto = punto;

        this.punto.setPosX(this.punto.getPosX() + vx);
        this.punto.setPosY(this.punto.getPosY() + vy);
        
        return this.punto;
    }
}