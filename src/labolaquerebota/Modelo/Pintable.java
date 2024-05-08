package labolaquerebota.Modelo;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public interface Pintable {
    public void draw(Graphics g);
    public void update(JFrame frame);
}