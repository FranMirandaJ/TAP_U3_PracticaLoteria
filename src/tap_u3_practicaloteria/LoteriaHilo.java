package tap_u3_practicaloteria;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class LoteriaHilo extends Thread {

    Ventana v;
    Set<Integer> numeros = new HashSet<>();
    private boolean ejecutarCodigo = true;

    public LoteriaHilo(Ventana v) {
        this.v = v;
    }

    public void run() {
            while(numeros.size() <= 54){
                if (ejecutarCodigo) {
                    Integer numero = (int) (Math.random() * 54) + 1;
                    if (numeros.add(numero)) {
                        v.lblCarta.setIcon(new ImageIcon("src/cartas/" + numero + ".png"));
                        try {
                            sleep(5000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LoteriaHilo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //System.out.println(numero);
                    } // IF añadio numero al HashSet
                }// IF ejecutarCodigo
            } // while principal
    }

}
