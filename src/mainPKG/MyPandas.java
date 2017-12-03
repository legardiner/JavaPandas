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
    ArrayList<String> state = new ArrayList<String> ();
    ArrayList<String> gender = new ArrayList<String> ();
    ArrayList<String> name = new ArrayList<String> ();
    ArrayList<Integer> year = new ArrayList<Integer>();
    ArrayList<Integer> count = new ArrayList<Integer> ();
    HashMap<String,Integer> colNames = new HashMap<String,Integer> ();
    HashMap<String, String> colTypes = new HashMap<String, String>();
    
    String names[]=scan.nextLine().split(",");
    String types[] = {"String", "String", "Integer", "String", "Integer"};
    for(int i = 0; i < names.length; i++) {
    		colNames.put(names[i].replaceAll("^\"|\"$", ""), i);
    		colTypes.put(names[i].replaceAll("^\"|\"$", ""), types[i]);
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
    ArrayList<ArrayList<?>> result = new ArrayList<ArrayList<?>> ();
    result.add(state);
    result.add(gender);
    result.add(year);
    result.add(name);
    result.add(count);
    return(new MyDataFrame(result, colNames, colTypes));
}

    public void writeCSV(MyDataFrame df, String path) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		for(int i = 0; i < df.data.get(0).size(); i++) { // for every row
			for(int j = 0; j < df.data.size(); j++) { // for each column
				writer.print(df.data.get(j).get(i) + ",");
			}
			writer.println();
		}
		writer.close();
    }
    
//    public MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {
//    		MyDataFrame copy = new MyDataFrame();
//    		for(int i = 0; i < df1.data.size(); i++) {
//    			ArrayList<?> colCopy = new ArrayList<Object>(df1.slice(i).data.get(0));
//    			copy.data.add(colCopy);
//    		}
//    		
//    		for(int i = 0; i < df1.data.size(); i++) {
//    			copy.data.get(i).addAll(df2.data.get(i));
//    		}
//    		
//    		result.getCol0().addAll(df2.getCol0());
//    		result.getCol1().addAll(df2.getCol1());
//    		result.getCol2().addAll(df2.getCol2());
//    		result.getCol3().addAll(df2.getCol3());
//    		result.getCol4().addAll(df2.getCol4());
//    		
//    		return result;
//    }
}
