package object;
import formulary.DropDown;
import java.util.Vector;
import principal.Function;
public class User extends BddObject {
	String idUser;
	String username;
	String password;
	String sexe;

	public User(){
		this.init();
		// efa avy nanao init
	}

	public User(String Username , String pass){
		this.init();
		this.setUsername(Username);
		this.setPassword(pass);
	}

	public User(String idUser) throws Exception{
		this.setIdUser(idUser);
		this.init();
	}

	public void login( String username , String password ) throws Exception{
		Vector<Object> users = this.select();
		
		if(users.size() == 0){
			throw new Exception("Veuillez verifier les identifiants saisis");
		}

		for( int i = 0; i < users.size() ; i++ ){
			User user = (User)users.get(i);
			if( user.getUsername().equals(username) && user.getPassword().equals(password) ){
				this.setIdUser(user.getIdUser());
				this.setUsername(user.getUsername());
				this.setPassword(user.getPassword());
				this.setSexe(user.getSexe());
				return;
			}
		}
	}

	public User getUser() throws Exception{
		try{
			User logged = (User)this.select(this.getIdUser()).get(0);
			return logged;

		}catch(Exception e){
			throw new Exception("Misy diso ny user");
		}
	}

	public void init(){
		super.setTable("users");
		super.setPrefix("USR");
		super.setSeqName("getUser");
		super.setPrimaryKey("idUser");
		super.setPrimaryValue(this.getIdUser());
	}

	public DropDown initializeComponent(){
		String[] sex = {"Male","Female"};
		String[] gender = {"M","F"};
		DropDown drop = new DropDown( Function.initialize(sex) , Function.initialize(gender) );
		return drop;
	}

	// sao de ato no tokony asiana azy

	public Annexe getCriterial() throws Exception{
		Annexe annexe = new Annexe(this.getIdUser());
		return annexe.getAnnexe();
	}

	public Info getInfo() throws Exception{
		Info myInfo = new Info(this.getIdUser());
		return myInfo.getInfo();
	}

	public void setIdUser(String id) throws Exception{
		if( id == null ){
			throw new Exception("IdUser is null");
		}
		this.idUser = id;
	}
	public void setUsername(String user){
		this.username = user;
	}
	public void setPassword(String pass){
		this.password = pass;
	}
	public void setSexe(String sex){
		this.sexe = sex;
	}

	public String getIdUser(){
		return this.idUser;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	public String getSexe(){
		return this.sexe;
	}

}