package labolaquerebota.Controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

import labolaquerebota.Modelo.Pintable;
import labolaquerebota.Vista.VentanaJuego;
import labolaquerebota.utils.Eventos;

/**
 *
 * @author david
 */
public class VentanaJuego_Controller implements WindowListener {

    private final ArrayList<Pintable> pintables;
    private final VentanaJuego vj;
    private final JFrame mainFrame;

    private final Eventos ev = new Eventos();

    public VentanaJuego_Controller(VentanaJuego vj) {
        this.vj = vj;
        this.pintables = vj.getObjetosPintables();
        this.mainFrame = vj.getFramePrincipal();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        (new Thread(new MovementObjectsRunnable(this.pintables, this.mainFrame, this.vj))).start();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ev.exitEvent(mainFrame);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

class MovementObjectsRunnable implements Runnable {

    private final ArrayList<Pintable> pintables;
    private final VentanaJuego vj;
    private final JFrame mainFrame;
    
    public MovementObjectsRunnable(ArrayList<Pintable> pintables, JFrame mainFrame, VentanaJuego vj) {
        this.mainFrame = mainFrame;
        this.pintables = pintables;
        this.vj = vj;
    }
    
    @Override
    public void run() {

        while (true) {
            for (Pintable p : this.pintables) {
                p.update(this.mainFrame);
            }

            /* Give Swing 10 milliseconds to see the update! */
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex1) {
                ex1.printStackTrace();
            }

            vj.repaintFramePrincipal();
        }
    }

}
