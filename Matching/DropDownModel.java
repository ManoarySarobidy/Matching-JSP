package formulary;
import javax.swing.*;

public class DropDownModel extends DefaultComboBoxModel<Object>{
    Object[] model;
    public DropDownModel(Object[] mode){
        super( mode );
        this.model = mode;
    }
    public void setModel(Object[] o){
        this.model = o;
    }
    public Object[] getModel(){
        return this.model;
    }
}