package listener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.*;
import formulary.*;
import reader.*;
import object.*;
import java.util.*;
import window.Welcome;
import java.lang.reflect.*;
public class SaveListener implements MouseListener{
    Formulaire formulaire;
    public SaveListener(Formulaire form){
        this.setForm(form);
    }
    // Mila mandray an'ilay zavatra henoiny
    public void mousePressed(MouseEvent e){
        JButton save = (JButton)e.getSource();
        JButton read = (JButton)e.getSource();
        if(e.getSource() instanceof JButton && save.getText()=="Sign Up"){
            Object[] data = this.collectData();
            if( checking(data) ){
                try{
                    Annexe annexe = new Annexe();
                    Welcome welcome = new Welcome( annexe );
                    reset();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            System.out.println("ok");
        }else if( e.getSource() instanceof JButton && save.getText() == "Show all" ){
            System.out.println("read");
        }
    }
    public void mouseExited(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }

    public boolean checking(Object[] data){
        // tokony hoe ilay data no tsy alaina
        for( Object d : data ){

            if( (String.valueOf(d)).isEmpty() || (String.valueOf(d)).startsWith("-") ){
                return false;
            }
        }
        return true;
    }
    
    public Object[] collectData(){
        // rehefa tonga ao dia alaina daholo aloha izay components rehetra
        Vector<Object> data = new Vector<>();
        Vector<Champ> compo = this.getFormulaire().getListeChamp();
        for( int i = 0 ; i < compo.size() ; i++ ){
            Object o = compo.get(i).getValue();
            // System.out.println(o);
            data.add(o);
        }
        return data.toArray();
    }
    public void reset(){
        Vector<Champ> compo = this.getFormulaire().getListeChamp();
        for( int i = 0 ; i < compo.size() ; i++ ){
            compo.get(i).reset();
        }
    }
    
    public void setForm(Formulaire f){
        this.formulaire = f;
    }
    public Formulaire getFormulaire(){
        return this.formulaire;
    }
}