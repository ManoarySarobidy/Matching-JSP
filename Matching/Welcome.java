package window;
import javax.swing.*;
import java.awt.*;
import formulary.*;
import listener.*;
public class Welcome extends JFrame{
    Formulaire form;
    Object reference;
    public Welcome(Object objet) throws Exception{
        this.setTitle("Inscription");
        this.setObject(objet);
        this.setForm();
        this.modifyForm();
        this.add(this.getForm());
        this.setLayout(new GridLayout(1,1));
        this.setSize(600,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void modifyForm() throws Exception{
        // this.getForm().getListeChamp().get(1).setComposant((JComponent)this.getObjet().getClass().getMethod("initializeComponent").invoke(this.getObjet()));

    }
    public void setForm() throws Exception{
        this.form = new Formulaire(this.getObjet());
    }
    public void setObject(Object objet){
        this.reference = objet;
    }
    public Object getObjet(){
        return this.reference;
    }
    public Formulaire getForm(){
        return this.form;
    }
}