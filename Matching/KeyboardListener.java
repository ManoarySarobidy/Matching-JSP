package listener;
import java.awt.event.*;
import formulary.Champ;
import javax.swing.JComponent;
public class KeyboardListener implements KeyListener{
    JComponent champ;
    public KeyboardListener(JComponent c){
        this.setChamp(c);
    }
    public void keyPressed(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){
        char typed = e.getKeyChar();
        if( (typed < '0' || typed > '9') && typed != KeyEvent.VK_BACK_SPACE ){
            e.consume();
        }
    }
    public void keyReleased(KeyEvent e){

    }
    public void setChamp(JComponent c){
        this.champ = c;
    }
    public JComponent getChamp(){
        return this.champ;
    }
}