package formulary;
import listener.*;
import javax.swing.*;
import java.util.*;
import principal.Function;
public class Champ{
    JComponent composant=new JTextField();
    JLabel titre;
    String title;
    boolean visible = true;
    String defaults;
    KeyboardListener listener;
    int rang;
    String name;
    String style;
    String type;
    public Champ(JComponent c,String t,String def,int rank){
        this.titre = new JLabel();
        this.setComposant( c );
        this.setTitle( t );
        this.setDefault( def );
        this.setOrder( rank );
        this.setType("text");
    }
    public Champ(String t,String def,int rank){
        this.titre = new JLabel();
        String n = t;
        this.setTitle( t );
        this.setDefault( def );
        this.setOrder( rank );
        this.setName( n );
        this.setType("text");
    }
    public void setDefault(String c){
        this.defaults = c;
        reset();
    }

    public Object getValue(){
        if(this.getComposant() instanceof JTextField){
            return ( (JTextField)this.getComposant() ).getText();
        } else if(this.getComposant() instanceof DropDown){
            return ((JComboBox)this.getComposant()).getSelectedItem();
        } else if(this.getComposant() instanceof JSpinner){
            return ((JSpinner)this.getComposant()).getValue();
        }
        return "";
    }
    public void reset(){
        if(this.getComposant() instanceof JTextField){
            ((JTextField)this.getComposant()).setText(this.getDefault());
        } else if(this.getComposant() instanceof DropDown){
            ((DropDown)this.getComposant()).setSelectedItem(((DropDown)this.getComposant()).getSelected(this.defaults));
        } else if(this.getComposant() instanceof JSpinner){
            ((JSpinner)this.getComposant()).setValue(10);
        }
        // return "";
    }

    public void initializeBool(){
        this.setComposant( new DropDown( this.TrueFalse() , this.TrueFalse() ) );
    }

    public Vector<Object> TrueFalse(){
        String[] trues = { "True","False" };
        return Function.initialize(trues);
    }

    public void setOrder(int c){
        this.rang = c;
    }
    public void setListener(){
        this.listener = new KeyboardListener( this.getComposant() );
        this.getComposant().addKeyListener( listener );
    }
    public void setComposant(JComponent c){
        this.composant = c;
    }
    public void setTitle(String c){
        this.title = c;
        this.titre.setText(title);
    }
    public void setVisibility(boolean c){
        this.visible = c;
        this.getComposant().setVisible(this.visible);
        this.getTitle().setVisible(this.visible);
    }
    public void setName(String name){
        this.getComposant().setName(name);
    }

    public void setType( String types ){
        this.type = types;
    }


    public JComponent getComposant(){
        return this.composant;
    }
    public JLabel getTitle(){
        return this.titre;
    }
    public boolean getVisibility(){
        return this.visible;
    }
    public String getDefault(){
        return this.defaults;
    }
    public int getOrder(){
        return this.rang;
    }
    public KeyboardListener getListener(){
        return this.listener;
    }
    public String getName(){
        return this.name;
    }
    public String getStyle(){
        return this.style;
    }
    public String getType(){
        return this.type;
    }
    public String getHtml(){
        String balise = new String();
        if(this.getComposant() instanceof JTextField){

            balise = this.getTitle().getText() + "<input type=\"" + this.getType() + "\" name=\"" + this.getComposant().getName() + "\" value=\"" + this.getDefault() + "\" >";
        
        }else if(this.getComposant() instanceof DropDown)
            balise = getDropList();
        
        return balise;
    }
    public String getDropList(){
        String pre = this.getTitle().getText() + "<Select name=\"" + this.getTitle().getText() + "\">";
        DropDown drop = (DropDown) this.getComposant();
        
        for( int i = 0 ; i < drop.getFront().size() ; i++ ){
            String option = "<option value=\"" + String.valueOf( drop.getBack().get(i) ) + "\">" + String.valueOf( drop.getFront().get(i) ) + "</option>";
            pre += option;

        }
        pre += "</select>";
        return pre;    
    }

}