package labolaquerebota;

import labolaquerebota.Modelo.MovimientoCircularUniforme;
import labolaquerebota.Modelo.MovimientoRectilineo;
import java.awt.Color;
import java.util.ArrayList;
import labolaquerebota.Modelo.Pelota;
import labolaquerebota.Modelo.Pintable;
import labolaquerebota.Modelo.Punto;
import labolaquerebota.Vista.VentanaJuego;

/**
 *
 * @author david
 */
public class LaBolaQueRebota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Pintable> pelotas = new ArrayList<>();
        int windowWidth = 640;
        int windowHeight = 480;

        /* Generate balls */
        for (int i = 0; i < 3; i++) {
            int vx = 0, vy = 0;

            while (vx == 0 || vy == 0) {
                vx = (int) Math.floor((Math.random() * 10) - 5);
                vy = (int) Math.floor((Math.random() * 10) - 5);
            }

            Pelota pelota = new Pelota(
                    /* Random positions from 0 to windowWidth or windowHeight */
                    new Punto((int) Math.floor(Math.random() * windowWidth), (int) Math.floor(Math.random() * windowHeight)),
                    /* Random size from 10 to 30 */
                    (int) Math.floor(Math.random() * 20) + 10,
                    /* Random RGB colors*/
                    new Color(
                            (int) Math.floor((Math.random() * 256)),
                            (int) Math.floor((Math.random() * 256)),
                            (int) Math.floor((Math.random() * 256))
                    ),
                    new MovimientoRectilineo(
                            /* Random velocities from -5 to 5 */
                            vx, vy
                    )
            );

            pelotas.add(pelota);
        }

        VentanaJuego juego = new VentanaJuego(windowWidth, windowHeight, pelotas);

        while (true) {
            int vx = 0, vy = 0;

            while (vx == 0 || vy == 0) {
                vx = (int) Math.floor((Math.random() * 10) - 5);
                vy = (int) Math.floor((Math.random() * 10) - 5);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex1) {
            }

            Pelota pelota = (Pelota) pelotas.get(1);
            pelota.setTipoMovimiento(new MovimientoCircularUniforme(vx, vy));
            pelotas.set(1, pelota);

            System.out.println("movimiento curvas");
            juego.setObjetosPintables(pelotas);
            
            vx = 0; vy = 0;

            while (vx == 0 || vy == 0) {
                vx = (int) Math.floor((Math.random() * 10) - 5);
                vy = (int) Math.floor((Math.random() * 10) - 5);
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex1) {
            }

            pelota.setTipoMovimiento(new MovimientoRectilineo(vx, vy));
            pelotas.set(1, pelota);

            System.out.println("movimiento recto");
            juego.setObjetosPintables(pelotas);
        }
    }
}
