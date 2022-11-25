package formulary;
import javax.swing.*;
import java.util.Vector;
public class DropDown extends JComboBox<Object>{
    Vector<Object> frontEnd;
    Vector<Object> backEnd;

    public DropDown(Vector<Object> front,Vector<Object> back){
        super( front );
        super.setLightWeightPopupEnabled(false);
        this.setFront(front);
        this.setBack(back);
        this.setOpaque(true);
    }

    public DropDown(){
        
    }

    public Object getSelected(int index){
        return backEnd.get(index);
    }

    public Object getSelected(Object name){

        for (int i = 0 ; i < this.getBack().size() ; i++){
            if(this.getBack().get(i).equals( name )){
                return this.getBack().get(i);
            }
        }
        return null;
    }

    public void setFront(Vector<Object> f){
        this.frontEnd = f;
    }

    public void setBack(Vector<Object> f){
        this.backEnd = f;
    }

    public Vector<Object> getBack(){
        return this.backEnd;
    }

    public Vector<Object> getFront(){
        return this.frontEnd;
    }
    
}