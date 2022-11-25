package reader;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
public class ReadWrite{
    FileOutputStream writer;
    FileInputStream reader;
    ObjectOutputStream write;
    ObjectInputStream read;
    BufferedReader reading;
    String path;
    String style;
    public ReadWrite(String filesName) throws Exception{
        this.setPath(filesName);
    }
    public void writeData(Object objet) throws Exception{
        this.writer = new FileOutputStream(this.getPath(),true);
        this.write = new ObjectOutputStream(this.getOutputStream());
        write.writeObject(objet);
        write.flush();
    }
    public Object[] readData() throws Exception{
        File checker = new File(this.getPath());
        this.reader = new FileInputStream(checker);
        Vector<Object> obj = new Vector<>();
        if( checker.length() != 0 ){
            while( true){
                try{
                    this.read = new ObjectInputStream(this.getInputStream());
                    Object reded = (Object)read.readObject();
                    obj.add(reded);
                    System.out.println(reded);
                }catch(Exception e){
                    break;
                }
            }
        }
        return obj.toArray();
    }
    public String getHtml(Object[] e){
        String all = "";
        if(e.length > 0){
            for( Object o : e ){
                String tr = "<tr>";
                String[] splits = ((String)o.toString()).split(";;");
                for(String j : splits){
                    tr += "<td>" + j + "</td>";
                }
                tr += "</tr>";
                all += tr;
            }
        }
        return all;
    }
    public void setPath(String pa){
        this.path = pa;
    }
    public String getPath(){
        return this.path;
    }
    public FileInputStream getInputStream(){
        return this.reader;
    }
    public FileOutputStream getOutputStream(){
        return this.writer;
    }
}