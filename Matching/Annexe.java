package object;

import formulary.DropDown;
import principal.Function;

public class Annexe extends BddObject{

	String idAnnexe;
	double salary;
	double nationality;
	double finoana;
	double diplome;
	double mifoka;
	double teinte;
	double longeur;
	String idUser;

	public Annexe(){
		init();
	}
	public Annexe(String idUser) throws Exception{
		this.setIdUser(idUser);
		this.init();
	}
	public void init(){
		super.setTable("annexe");
		super.setPrimaryKey("idUser");
		super.setPrimaryValue(this.getIdUser());
		super.setPrefix("ANX");
		super.setSeqName("getAnx");
	}

	public Annexe getAnnexe() throws Exception{
		try{
			Annexe annexe = (Annexe)this.select(this.getIdUser()).get(0);
			return annexe;
		}catch(Exception e){
			throw new Exception("Tsy manana annexe io olona io :" + this.getIdUser());
		}
	}

	public void setIdAnnexe( String idAnx ) throws Exception{
		if( idAnx == null ){
			throw new Exception("L'IdAnx est null");
		}
		this.idAnnexe = idAnx;
	}
	public void setSalary( double salaire ){
		this.salary = salaire;
	}
	public void setNationality(double nation){
		this.nationality = nation;
	}
	public void setFinoana( double mpino ){
		this.finoana = mpino;
	}
	public void setDiplome(double niveau){
		this.diplome = niveau;
	}
	public void setMifoka( double smoke ){
		this.mifoka = smoke;
	}
	public void setTeinte(double teint){
		this.teinte = teint;
	}
	public void setLongeur(double longe){
		this.longeur = longe;
	}
	public void setIdUser(String idU) throws Exception{
		if (idU == null) {
			throw new Exception("L'IdUtilisateur n'est pas valide");
		}
		this.idUser = idU;
	}

	public String getIdAnnexe(){
		return this.idAnnexe;
	}
	public double getSalary(){
		return this.salary;
	}
	public double getNationality(){
		return this.nationality;
	}
	public double getFinoana(){
		return this.finoana;
	}
	public double getDiplome(){
		return this.diplome;
	}
	public double getMifoka(){
		return this.mifoka;
	}
	public double getTeinte(){
		return this.teinte;
	}
	public double getLongeur(){
		return this.longeur;
	}
	public String getIdUser(){
		return this.idUser;
	}

	// si on veut preciser des criteres

	public DropDown initializeComponent() throws Exception{
		String[] nationality = {"Malagasy","Europeanina"};
		Double[] back = { 15.0 , -4.0 };
		DropDown dropdown = new DropDown( Function.initialize(nationality), Function.initialize(back) );
		return dropdown;
	}
	public DropDown initializeSalaire() throws Exception{
		String[] salary = {"Tsy an'asa","100000 Ar","200000 Ar - 400000 Ar","400000 Ar - 600000 Ar","600000 Ar - 700000 Ar","800000 Ar - 900000 Ar","1000000 Ar +"};
		Double[] coefficient = { -3.0 , 8.0	, 10.0 , 12.0 , 14.0 ,16.0 , 18.0 };
		DropDown dropdown = new DropDown( Function.initialize(salary), Function.initialize(coefficient) );
		return dropdown;
	}
	public DropDown initializeFinoana() throws Exception{
		String[] finoana = { "Mpino" , "Tsy mpino" };
		Double[] back = { 16.0 , -2.0 };
		DropDown dropdown = new DropDown( Function.initialize(finoana), Function.initialize(back) );
		return dropdown;
	}
	public DropDown initializeDiplome() throws Exception{
		String[] degres = { "Tsy nianatra", "Bacc"," Bacc + 1 "," Bacc + 2 ", "License", "Master 1" , "Master 2"};
		Double[] back = { -1.0, 6.0, 9.0, 11.0, 13.0, 15.0, 17.0};
		DropDown dropdown = new DropDown( Function.initialize(degres), Function.initialize(back) );
		return dropdown;
	}

	public DropDown initializeSmoke() throws Exception{
		String[] smokes = { "Fumeur" , "Non Fumeur" };
		Double[] values = { 14.0 , -5.0 };
		DropDown dropdown = new DropDown( Function.initialize(smokes) , Function.initialize(values) );
		return dropdown;
	}

	public DropDown initializeTeinte() throws Exception{
		String[] teinte = { "Fotsy"," Mainty"};
		Double[] back = { 15.0 , -5.0 };
		DropDown dropdown = new DropDown( Function.initialize( teinte ), Function.initialize(back) );
		return dropdown;
	}

	public DropDown initializeLongeur() throws Exception{
		String[] longeur = { "Lava","fohy"};
		Double[] back = { 17.0 , -6.0 };
		DropDown dropdown = new DropDown( Function.initialize( longeur ), Function.initialize(back) );
		return dropdown;
	}
}