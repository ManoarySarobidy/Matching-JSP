package formulary;
// import objet.human.*;
import java.awt.*;
import reader.*;
import javax.swing.*;
import java.util.*;
import java.lang.reflect.*;
import listener.*;
public class Formulaire extends JPanel{
    SaveListener listener;
    Vector<JComponent> composant;
    ReadWrite files;
    Button save;
    Vector<Champ> composants;
    Button read;
    Object ref;
    int[] order;
    public Formulaire(){}
    public Formulaire(Object objet) throws Exception{
        // order={1,2,3,4,5};
        this.setObject(objet);
        composant = new Vector<>();
        composants = new Vector<>();
        this.setLayout( new GridLayout(10,1));
        this.initializeComponent(objet);
        this.initializeButton();
        // this.files = new ReadWrite((String)this.ref.getClass().getDeclaredMethod("getFileName").invoke(this.getRef()));
    }
    public void paint(Graphics g){
        super.paint(g);
        this.setToPanel();
    }
    public void initializeComponent(Object toCreate) throws Exception{
        Field[] composante = toCreate.getClass().getDeclaredFields();
        String method = "initializeComponent";
        int rang = 1;
        for( Field f : composante ){
            Champ cmp = new Champ( f.getName() , "" , rang );
            if( f.getType() == boolean.class ){
                cmp.initializeBool();
            }
            this.composants.add(cmp);
            rang++;
        }
    }
    public void initializeButton(){
        this.setSave();
        this.composant.add(save);
    }
    
    public void setToPanel(){ 
        for( int i = 1 ; i <= this.getListeChamp().size() ; i++ ){
            for( int j = 0 ; j < this.getListeChamp().size() ; j++){
                if( this.getListeChamp().get(j).getOrder() == i && this.getListeChamp().get(j).getVisibility() ){
                    this.add( this.getListeChamp().get(j).getTitle() );
                    this.add( this.getListeChamp().get(j).getComposant() );
                }
            }
        }
        for( int i = 0 ; i < this.getComposant().size() ; i++ ){
            this.add( this.getComposant().get(i) );
        }
    }

    public void updateOrder(int toChange,int indice){
        Champ tmp1 = this.getListeChamp().get(toChange);
        Champ tmp2 = this.getListeChamp().get(indice);
        int rank = tmp1.getOrder();
        // rehefa azoko dia afamadiko ftsn ny rang
        tmp1.setOrder(tmp2.getOrder());
        tmp2.setOrder(rank);

    }

    public void setComponent(Vector<JComponent> compo){
        this.composant = compo;
    }

    public void setObject(Object b){
        this.ref = b;
    }
    public void setOrder(int[] ordre){
        this.order = ordre;
    }
    public void setSave(){
        save = new Button("Sign Up",this);
    }
    public SaveListener getListener(){
        return this.listener;
    }    
    public Vector<JComponent> getComposant(){
        return this.composant;
    }
    public Vector<Champ> getListeChamp(){
        return this.composants;
    }
    public Button getButton(){
        return this.save;
    }
    public int[] getOrder(){
        return this.order;
    }
    public Object getRef(){
        return this.ref;
    }
    public ReadWrite getFiles(){
        return this.files;
    }
	// ahoana no ataoko raha ohatra ka tiako ho avadika formulaire ilay izy
    public String getHtml(){
    	// String form = "<form method=\"POST\">";
    	String content="";
    	for(int i = 0 ; i < this.getListeChamp().size() ; i++){
            if( this.getListeChamp().get(i).getVisibility()  ){
    		  content += this.getListeChamp().get(i).getHtml();
            }
    	}
    	
    	return content;
    }
}