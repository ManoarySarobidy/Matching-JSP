package principal;
import java.lang.reflect.*;
import java.util.Vector;
// import java.Math
public class Function{
    public static Object sum( Vector<Object> object,String method) throws Exception{
        double sum = 0;
        for(int i = 0 ; i < object.size() ; i++){
            Method toGet = object.get(i).getClass().getMethod(method);
            sum += (double)toGet.invoke(object.get(i));
        }
        return sum;
    }
    public static double mean(Vector<Object> object,String method) throws Exception{
        Object somme = sum(object,method);
        return ((double)somme)/object.size();
    }
    public static void sort(Vector<Object> object,String method,int order) throws Exception{
        for(int i = 0 ; i < object.size() ; i++){
            for( int j = 0 ; j < object.size() ; j++){
                Object tmp = object.get(i);
                if( minOfTwo( object.get(i) , object.get(j) ,method) ){
                    Object tm = object.get(j);
                    object.set( i , tm);
                    object.set( j , tmp);
                }
            }
        }
    }

    public static void triFusion(Object[] toSort){
        if(toSort.length <= 1) return;
        double middle = Math.ceil( toSort.length / 2 );
        Object[] left = new Object[(int)middle];
        Object[] right = new Object[ toSort.length - (int)middle ];
        int j = 0;
        for( int i = 0 ; i < toSort.length; i++ ){
            if( i < left.length ){
                left[i] = toSort[i];
            }else{
                right[j] = toSort[i];
                j++;
            }
        } 
        triFusion(left);
        triFusion(right);
        fusion( left , right , toSort );
    }

    public static  void fusion( Object[] left , Object[] right , Object[] original ){
        int le = 0 , ri = 0 , i = 0;
        while( le < left.length && ri < right.length ){
            double l = (double)left[le]; 
            double r = (double)right[ri]; 
            if( l < r ){ 
                original[i] = l;
                i++;
                le++;
            }else{
                original[i] = r;
                i++;
                ri++;
            }
        }
        complete( i , le , original , left);
        complete( i , ri , original , right);
    }
    public static void complete( int indexOne , int index2 , Object[] toFill , Object[] toGet ){
        while( index2 < toGet.length ){
            toFill[indexOne] = toGet[index2];
            indexOne++;
            index2++;
        }
    }

    public static boolean minOfTwo( Object a , Object b , String method ) throws Exception{
        double min = (double)a.getClass().getMethod(method).invoke(a);
        if( (double) b.getClass().getMethod(method).invoke(b) <= min ){
            return true;
        }
        return false;
    }
    public static Vector<String> getMonths(){
        String[] ans = { "Jan" , "Fev" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec" };
        Vector<String> an = new Vector<>();
        for( String mois : ans ){
            an.add(mois);
        }
        return an;
    }
    public static Vector<Integer> getSpecific(int depart,int fin){
        Vector<Integer> retour = new Vector<>();
        for( depart = depart ; depart <= fin ; depart++){
            retour.add(depart);
        }
        return retour;
    }
    public static Vector<Object> initialize(Object[] toAdd){
        Vector<Object> object = new Vector<>();
        for( Object obj : toAdd ){
            object.add(obj);
            
        }
        return object;
    }
}