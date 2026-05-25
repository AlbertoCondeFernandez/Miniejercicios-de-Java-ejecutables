
import javax.swing.SwingUtilities;

public class BurgerMenuApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BurgerMenuFrame frame = new BurgerMenuFrame();
            frame.setVisible(true);
        });
    }
}
//Alberto Conde Fernández
/* 
La idea es hacer una app de escritorio en Java con Swing que
parezca un restaurante de comida rápida
*/