package labolaquerebota.Vista;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import labolaquerebota.Controlador.VentanaJuego_Controller;
import labolaquerebota.Modelo.Pintable;

/**
 *
 * @author david
 */
public class VentanaJuego {
    private final JFrame mainFrame;
    private final DrawPanel drawPanel;
    private ArrayList<Pintable> pintables;

    private final int windowWidth;
    private final int windowHeight;
    private final String windowLabel = "Bounce Program";

    public VentanaJuego(int windowWidth, int windowHeight, ArrayList<Pintable> pintables) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.pintables = pintables;
        
        mainFrame = new JFrame();
        drawPanel = new DrawPanel();
        mainFrame.getContentPane().add(drawPanel);
        mainFrame.setTitle(windowLabel);
        mainFrame.setSize(this.windowWidth, this.windowHeight);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        mainFrame.addWindowListener(new VentanaJuego_Controller(this));
    }
    
    public ArrayList<Pintable> getObjetosPintables() {
        return this.pintables;
    }
    
    public void setObjetosPintables(ArrayList<Pintable> pintables) {
        this.pintables = pintables;
    }
    
    public JFrame getFramePrincipal() {
        return this.mainFrame;
    }
    
    public void repaintFramePrincipal() {
        this.drawPanel.paintComponent(this.drawPanel.getGraphics());
    }

    class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            for (Pintable p: pintables) {
                p.draw(graphics);
            }

        }
    }
}