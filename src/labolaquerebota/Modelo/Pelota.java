package labolaquerebota.Modelo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public class Pelota implements Pintable, Movimiento {

    private Punto punto;
    private Color color;
    private Movimiento tipoMovimiento;
    private int size;

    public Pelota(Punto punto, int size, Color color, Movimiento tipoMovimiento) {
        this.punto = punto;
        this.size = size;
        this.color = color;
        this.tipoMovimiento = tipoMovimiento;
    }

    @Override
    public void update(JFrame frame) {
        this.punto = desplazar(this.punto, this.size, frame);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(punto.getPosX(), punto.getPosY(), size, size);
    }

    @Override
    public Punto desplazar(Punto punto, int size, JFrame frame) {
        return tipoMovimiento.desplazar(punto, size, frame);
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Movimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setTipoMovimiento(Movimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    
    
}
