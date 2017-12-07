package mainPKG;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
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
    
    @SuppressWarnings("unchecked")
	public MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) throws Exception {
    		MyDataFrame result = new MyDataFrame();
    		if (df1.data.size() == df2.data.size()) {
    			for(int i = 0; i < df1.data.size(); i++) {
    				if (df1.dType(i).equals("String")) {
    					ArrayList<String> both  =  new ArrayList<String> ();
    					both.addAll((Collection<? extends String>) df1.data.get(i)); 
    					both.addAll((Collection<? extends String>) df2.data.get(i));
    					result.data.add(both);
    				}
    				if (df1.dType(i).equals("Integer")) {
    					ArrayList<Integer> both  =  new ArrayList<Integer> ();
    					both.addAll((Collection<? extends Integer>) df1.data.get(i)); 
    					both.addAll((Collection<? extends Integer>) df2.data.get(i));
    					result.data.add(both);
    				}
        		}
        		result.setColNames(df1.getColNames());
        		result.setColTypes(df1.colTypes);
        		return result;
    		}
    		else {
    			throw new Exception("Your dataframes do not have the same number of columns");
    		}
    }
}
