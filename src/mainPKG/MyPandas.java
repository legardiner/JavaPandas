package mainPKG;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyPandas {

    public MyDataFrame readCSV(String path) throws FileNotFoundException {
    		Scanner scan = new Scanner(new File(path));
	    ArrayList<String> state = new ArrayList<String> ();
	    ArrayList<String> gender = new ArrayList<String> ();
	    ArrayList<String> name = new ArrayList<String> ();
	    ArrayList<Integer> year = new ArrayList<Integer> ();
	    ArrayList<Integer> count = new ArrayList<Integer> ();
	    
	    scan.nextLine(); // skip the first line with headers
	    while(scan.hasNextLine()){
	    		String temp[]=scan.nextLine().split(",");
	    		state.add(temp[1]);
	    		gender.add(temp[2]);
	    		year.add(Integer.parseInt(temp[3]));
	    		name.add(temp[4]);
	    		count.add(Integer.parseInt(temp[5]));
	    		}
	    scan.close();
	    return(new MyDataFrame(state, gender, year, name, count));
    }
    /*
    public void writeCSV(MyDataFrame data, String path) {
        
    }
    
    public MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {
        return type; 
    }*/

}