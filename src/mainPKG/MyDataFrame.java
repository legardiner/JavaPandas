package mainPKG;
import java.util.ArrayList;

public class MyDataFrame {
    private ArrayList<String> state; 
    private ArrayList<String> gender;
    private ArrayList<Integer> year;
    private ArrayList<String> name;
    private ArrayList<Integer> count;
    
    public MyDataFrame(ArrayList<String> state, ArrayList<String> gender, ArrayList<Integer> year, 
    		ArrayList<String> name, ArrayList<Integer> count) {
    		this.state = state;
    		this.gender = gender;
    		this.year = year;
    		this.name = name;
    		this.count = count;  	
    }
    public ArrayList<String> getState() {
		return(this.state);
    }
    public ArrayList<String> getGender() {
		return(this.gender);
    }
    public ArrayList<Integer> getYear() {
		return(this.year);
    }
    public ArrayList<String> getName() {
    		return(this.name);
    }
    public ArrayList<Integer> getCount() {
    		return(this.count);
    }

	
	/*public MyDataFrame head(int n) {
		return rows;
	}
	
	public MyDataFrame tail(int n) {
		return rows;
	}
	
	public String dType(int index) {
		return type;
	}
	
	public String dType(String name) {
		return type;
	}
	
	public MyDataFrame slice(int index) {
		return column;
	}
	
	public MyDataFrame slice(String name) {
		return column;
	}
	
	public MyDataFrame slice(int[] indexArr) {
		return columns;
	}
	
	public MyDataFrame filter(String col, String op, Object o) {
		return filteredData;
	}
	
	public MyDataFrame loc(int index) {
		return rows;
	}
	
	public MyDataFrame loc(String label) {
		return rows;
	}
	
	public MyDataFrame loc(int from, int to) {
		return rows;
	}
	
	public MyDataFrame loc(String from, String to) {
		return rows;
	}
	
	public MyDataFrame sort(int index) {
		return sortedData;
	}
	
	public MyDataFrame sort(String name) {
		return sortedData;
	}
	
	public Object getMin(int index) {
		return min;
	}
	
	public Object getMin(String label) {
		return min;
	}
	
	public Object getMax(int index) {
		return max;
	}
	
	public Object getMax(String label) {
		return max;
	} */
}
