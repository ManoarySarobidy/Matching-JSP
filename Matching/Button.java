package formulary;
import listener.*;
import javax.swing.JButton;
public class Button extends JButton{
    SaveListener listener;
    public Button(String text,Formulaire f){
        super(text);
        this.setListener(f);
        this.addMouseListener(this.listener);
    }
    public void setListener(Formulaire f){
        this.listener = new SaveListener(f);
    }
    public SaveListener getListener(){
        return this.listener;
    }
}