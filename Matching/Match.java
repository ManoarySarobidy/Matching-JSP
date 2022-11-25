package object;
import java.lang.reflect.*;
import java.util.Vector;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;
public class Match {
	User user;
	Info userInfo;
	Annexe userAnnexe;
	double[] info;
	double[] annexe;
	double minimum;

	public Match(){

	}

	public Match(String idUser) throws Exception{
		this.setUser(idUser);
		this.common();
	}

	public Match( User user ) throws Exception{
		this.setUser(user);
		this.common();
	}

	public void common() throws Exception{
		this.setInfo();
		this.setAnnexe();
		this.setInfoNotes();
		this.setAnnexeNotes();
		this.setMinimum(14);
	}


	public TreeMap<Double,User> match() throws Exception{
		
		Vector<Object> users = this.getUser().select();
		HashMap<Double,User> hash = new HashMap<Double,User>();
		TreeMap<Double,User> compatible = new TreeMap<Double,User>();
		for( int i = 0 ; i < users.size() ; i++ ){
			User currentUser = (User) users.get(i);
			if( !this.getUser().getIdUser().equals(currentUser.getIdUser()) && !this.getUser().getSexe().equalsIgnoreCase(currentUser.getSexe()) ){
				Match usermatch = new Match( currentUser ); 
				double twoCompatibleWithOne = this.mean( this.getInfoNotes() , usermatch.getAnnexeNotes() ); // l'utilisateur2 est il compatible pour l'utilisateur 1
				double thisCompatibleWithTwo = this.mean( usermatch.getInfoNotes() , this.getAnnexeNotes() ); // cette utilisateur est il/elle compatible avec l'utilisateur2
				if( thisCompatibleWithTwo >= this.getMinimum() && twoCompatibleWithOne >= this.getMinimum() ){ // mbola mila jerena hoe anati'ny raikitra ve sa tsia
					hash.put( twoCompatibleWithOne , currentUser );
				}
			}
		}
		compatible.putAll(hash);
		return compatible;

	}

	public double mean(double[] marks , double[] coefficients){
		// calculena ny somme an'ny coefficients
		double sum = 0;
		for( double def : coefficients )
			sum += def;

		double finalMark = this.calculus( marks , coefficients );
		double means = finalMark / sum;
		return means;

	}

	public double calculus( double[] marks , double[] coefficients ){
		double sum = 0;
		for( int i = 0 ; i < marks.length ; i++ ){
			double curVal = marks[i] * coefficients[i];
			sum += curVal;
		}
		return sum;
	}
	

	// azoko izay ny note de ndao tediavina daholo izay ilaina
	public double[] getNotes( Object obj ) throws Exception{
		// depart manomboka 1 ho an' Info sy ho an' Annexe
		Field[] fields = obj.getClass().getDeclaredFields();
		double[] notes = new double[ fields.length - 2 ];
		for( int i = 1; i < fields.length - 1 ;i++ ){
			if( obj instanceof BddObject ){
				Method method = obj.getClass().getMethod("get"+((BddObject)obj).toUpperFirst(fields[i].getName()));
				double invokes = (double)method.invoke(obj);
				notes[i-1] = invokes;
			}
		} 
		return notes;
	}
// getters and setters
	public void setUser(User user) throws Exception{
		if( user == null ){
			throw new Exception("L'utilisateur n'est pas valide");
		}
		this.user = user;
	}

	public void setUser(String idUser) throws Exception{
		User users = new User(idUser);
		try{
			this.user = users.getUser();
		}catch(Exception e){
			throw new Exception("Cette Id n'existe pas");
		}
	}
	public void setInfo() throws Exception{
		// Info info = new Info(this.getUser().getIdUser());
		this.userInfo = this.getUser().getInfo();
	}

	public void setAnnexe() throws Exception{
		this.userAnnexe = this.getUser().getCriterial();
	}
	public void setInfoNotes() throws Exception{
		this.info = this.getNotes(this.getInfo());
	}
	public void setAnnexeNotes() throws Exception{
		this.annexe = this.getNotes(this.getAnnexe());
	}
	public void setMinimum(double minimum){
		this.minimum = minimum;
	}

	public User getUser(){
		return this.user;
	}
	public Info getInfo(){
		return this.userInfo;
	}
	public Annexe getAnnexe(){
		return this.userAnnexe;
	}
	public double[] getInfoNotes(){
		return this.info;
	}
	public double[] getAnnexeNotes(){
		return this.annexe;
	}
	public double getMinimum(){
		return this.minimum;
	}
}
