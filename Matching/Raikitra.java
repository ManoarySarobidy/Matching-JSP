package object;
import java.sql.Date;
import java.util.Vector;
public class Raikitra extends BddObject{
	String idRaikitra;
	String idUser1;
	String idUser2;
	Date dateRaikitra;

	public Raikitra(){
		this.init();
	}

	public Raikitra( String userOne , String userTwo ){
		this.setIdUser1( userOne );
		this.setIdUser2( userTwo );
		this.init();
	}

	public void init(){
		super.setTable("Raikitra");
		super.setPrimaryKey("idRaikitra");
		super.setPrimaryValue(this.getIdRaikitra());
		super.setPrefix("RKT");
	}

	// ato no milaza hoe jereo hoe ao sa tsia atao miretourne boolean izany ny ato
	// omeko azy fotsiny ilay id tiko jerena hoe ao sa tsy ao miaraka amin'ny id ako
	public boolean raikitra(String idUser) throws Exception{ // ijerena olona iray hoe efa engagé ve sa tsia
		Vector<Object> querys = this.select(query);
		for( int i = 0 ; i < querys.size() ; i++ ){
			Raikitra currRaikitra = (Raikitra) query.get(i);
			if(  ){

			}
		}
		return false;
	}

	public void setIdRaikitra( String id ){
		this.idRaikitra = id;
	}
	public void setIdUser1(String idUser){
		this.idUser1 = idUser;
	}
	public void setIdUser2(String idUser){
		this.idUser2 = idUser;
	}
	public void setDateRaikitra(Date raikitra){
		this.dateRaikitra = raikitra;
	}

	public String getIdRaikitra(){
		return this.idRaikitra;
	}
	public String getIdUser1(){
		return this.idUser1;
	}
	public String getIdUser2(){
		return this.idUser2;
	}
	public Date getDateRaikitra(){
		return this.dateRaikitra;
	}

}