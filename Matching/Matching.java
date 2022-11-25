package application;
import window.*;
import object.*;
import principal.Function;
public class Matching{
	public static void main(String[] args) throws Exception {
		// Person person = new Person();
		// Welcome welcome = new Welcome(person);
		// tsy misy test fa ny ora mandeha
		Object[] number = { 8.0 , 6.0 , 3.0 , 5.0 , 4.0 , 1.0 , 2.0 , 71827.0 ,7.0};
		Function.triFusion( number );
		for( Object o : number ){
				System.out.println(o);
		}
	}
}