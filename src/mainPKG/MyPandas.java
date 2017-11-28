package mainPKG;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class MyPandas {
    public MyDataFrame readCSV(String path) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(path));
    ArrayList<Object> state = new ArrayList<Object> ();
    ArrayList<Object> gender = new ArrayList<Object> ();
    ArrayList<Object> name = new ArrayList<Object> ();
    ArrayList<Object> year = new ArrayList<Object>();
    ArrayList<Object> count = new ArrayList<Object> ();
    HashMap<String,Integer> colNames = new HashMap<String,Integer> ();
    
    String names[]=scan.nextLine().split(",");
    for(int i = 0; i < names.length; i++) {
    		colNames.put(names[i].replaceAll("^\"|\"$", ""), i);
    }

    while(scan.hasNextLine()){
    		String temp[]=scan.nextLine().split(",");
    		state.add(temp[0]);
    		gender.add(temp[1]);
    		year.add(Integer.parseInt(temp[2]));
    		name.add(temp[3]);
    		count.add(Integer.parseInt(temp[4]));
    		}
    scan.close();
    return(new MyDataFrame(state, gender, year, name, count, colNames));
}

    public void writeCSV(MyDataFrame data, String path) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		for(int i = 0; i < data.getCol1().size(); i++) {
			writer.println(data.getCol0().get(i) + "," + data.getCol1().get(i) + "," +
					data.getCol2().get(i) + "," + data.getCol3().get(i) + "," + 
					data.getCol4().get(i));
		}
		writer.close();
    }
    
    public MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {
    		ArrayList<Object> col0 = new ArrayList<Object>(df1.getCol0());	
    		ArrayList<Object> col1 = new ArrayList<Object>(df1.getCol1());
    		ArrayList<Object> col2 = new ArrayList<Object>(df1.getCol2());
    		ArrayList<Object> col3 = new ArrayList<Object>(df1.getCol3());
    		ArrayList<Object> col4 = new ArrayList<Object>(df1.getCol4());
    		
	    
    		MyDataFrame result = new MyDataFrame(col0, col1, col2, col3, col4, df1.getColNames());
    		
    		result.getCol0().addAll(df2.getCol0());
    		result.getCol1().addAll(df2.getCol1());
    		result.getCol2().addAll(df2.getCol2());
    		result.getCol3().addAll(df2.getCol3());
    		result.getCol4().addAll(df2.getCol4());
    		
    		return result;
    }
}
