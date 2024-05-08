package labolaquerebota.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Eventos {
    public void exitEvent(JFrame frame) {
        int res = JOptionPane.showConfirmDialog(frame, 
                                          "¿Desea salir de la aplicación?", 
                                           "Confirmación", 
                                       JOptionPane.YES_NO_OPTION);
        
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}