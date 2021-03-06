package mainPKG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.IntStream;


public class MyDataFrame {
    
//	these should probably be private -- diminishing returns
    public ArrayList<ArrayList<?>> data; 
    public HashMap<String,Integer> colNames = new HashMap<String,Integer>();
    public HashMap<String,String> colTypes = new HashMap<String,String>();

    
    public MyDataFrame(ArrayList<ArrayList<?>> data, HashMap<String,Integer> colNames, HashMap<String,String> colTypes) {
    		this.data = data;
    		this.colNames = colNames;
    		this.colTypes = colTypes; 
    }

    public MyDataFrame() {
		this.data = new ArrayList<ArrayList<?>>();
    }
    
    public HashMap<String,Integer> getColNames() {
		return(this.colNames);
    }
    
    void setColNames(HashMap<String,Integer> colNames) {
		this.colNames = colNames;
    }
    
    void setColTypes(HashMap<String,String> colTypes) {
		this.colTypes = colTypes;
    }
    
    
	public MyDataFrame head(int n) {
		MyDataFrame result = new MyDataFrame();
		for(int i = 0; i < this.data.size(); i++) {
			ArrayList<?> subset  =  new ArrayList<>(this.data.get(i).subList(0, n));
			result.data.add(subset);
		}
		result.setColNames(this.getColNames());
		result.setColTypes(this.colTypes);
		return result;
	}
	
	public MyDataFrame tail(int n) {
		MyDataFrame result = new MyDataFrame();
		for(int i = 0; i < this.data.size(); i++) {
			ArrayList<?> subset  =  new ArrayList<>(this.data.get(i).subList(this.data.get(i).size()-n, this.data.get(i).size()));
			result.data.add(subset);
		}
		result.setColNames(this.getColNames());
		result.setColTypes(this.colTypes);
		return result;
	}


	public String dType(int index) {
		String colName = "";
        for (String key : this.colNames.keySet()){
        		if(this.colNames.get(key).equals(index)) {
        			colName = key;
        		}
        }
        return(this.dType(colName));
	}
	

	public String dType(String name) {
		if(!this.colTypes.containsKey(name)) {
			return "Not a valid index.";
		}
		return this.colTypes.get(name);
	}

	public MyDataFrame slice(int index) {
		MyDataFrame result = new MyDataFrame();
		result.data.add(this.data.get(index));
		String colName = "";
        for (String key : this.colNames.keySet()){
        		if(this.colNames.get(key).equals(index)) {
        			colName = key;
        		}
        }
        result.colNames.put(colName, 0);
        result.colTypes.put(colName, this.colTypes.get(colName));
		return result;
	}	
		
	public MyDataFrame slice(String name) {
		int index = this.getColNames().get(name);
		return this.slice(index);
	}
	
	public MyDataFrame slice(int[] indexArr) {
		MyDataFrame result = new MyDataFrame();
		int colNum = 0; 
		for(int index: indexArr) {
			String key = this.slice(index).getColNames().keySet().toString();
			key = key.replaceAll("\\p{P}","");
			result.colNames.put(key, colNum);
			result.data.add(this.slice(index).data.get(0));
			result.colTypes.put(key, this.colTypes.get(key));
			colNum++;
		}
		return result;
	}

	public MyDataFrame slice(String[] nameArr) {
		int[] convert = new int[nameArr.length];
		int i = 0;
		for(String index: nameArr) {
			convert[i] = this.colNames.get(index);
			i++;
		}
	return this.slice(convert);
}
	
	public MyDataFrame filter(String col, String op, Object o) {
		MyDataFrame result = new MyDataFrame();
		ArrayList<String> filterState = new ArrayList<String> ();
	    ArrayList<String> filterGender = new ArrayList<String> ();
	    ArrayList<String> filterName = new ArrayList<String> ();
	    ArrayList<Integer> filterYear = new ArrayList<Integer>();
	    ArrayList<Integer> filterCount = new ArrayList<Integer> ();
		Integer colNum = this.colNames.get(col);
		if (op.equals("=") && this.dType(colNum).equals("String")) {
			for(int row = 0; row < this.data.get(colNum).size(); row++) {
				if (((String) this.data.get(colNum).get(row)).replaceAll("^\"|\"$", "").equals(o)) {
		    			filterState.add((String) this.data.get(0).get(row));
		    			filterGender.add((String) this.data.get(1).get(row));
		    			filterYear.add((Integer) this.data.get(2).get(row));
		    			filterName.add((String) this.data.get(3).get(row));
		    			filterCount.add((Integer) this.data.get(4).get(row));
				}
			}
		}
		else if (op.equals("=") && this.dType(colNum).equals("Integer")) {
			for(int row = 0; row < this.data.get(colNum).size(); row++) {
				if (this.data.get(colNum).get(row).equals(o)) {
		    			filterState.add((String) this.data.get(0).get(row));
		    			filterGender.add((String) this.data.get(1).get(row));
		    			filterYear.add((Integer) this.data.get(2).get(row));
		    			filterName.add((String) this.data.get(3).get(row));
		    			filterCount.add((Integer) this.data.get(4).get(row));
				}
			}
		}
		else if (op.equals(">") && this.dType(colNum).equals("String")) {
			for(int row = 0; row < this.data.get(colNum).size(); row++) {
				if (((String) this.data.get(colNum).get(row)).replaceAll("^\"|\"$", "").compareTo((String) o) > 0) {
		    			filterState.add((String) this.data.get(0).get(row));
		    			filterGender.add((String) this.data.get(1).get(row));
		    			filterYear.add((Integer) this.data.get(2).get(row));
		    			filterName.add((String) this.data.get(3).get(row));
		    			filterCount.add((Integer) this.data.get(4).get(row));
				}
			}
		}
		else if (op.equals(">") && this.dType(colNum).equals("Integer")) {
			for(int row = 0; row < this.data.get(colNum).size(); row++) {
				if (((Integer) this.data.get(colNum).get(row)).compareTo((Integer) o) > 0) {
		    			filterState.add((String) this.data.get(0).get(row));
		    			filterGender.add((String) this.data.get(1).get(row));
		    			filterYear.add((Integer) this.data.get(2).get(row));
		    			filterName.add((String) this.data.get(3).get(row));
		    			filterCount.add((Integer) this.data.get(4).get(row));
				}
			}
		}
		else if (op.equals("<") && this.dType(colNum).equals("String")) {
			for(int row = 0; row < this.data.get(colNum).size(); row++) {
				if (((String) this.data.get(colNum).get(row)).replaceAll("^\"|\"$", "").compareTo((String) o) < 0) {
		    			filterState.add((String) this.data.get(0).get(row));
		    			filterGender.add((String) this.data.get(1).get(row));
		    			filterYear.add((Integer) this.data.get(2).get(row));
		    			filterName.add((String) this.data.get(3).get(row));
		    			filterCount.add((Integer) this.data.get(4).get(row));
				}
			}
		}
		else if (op.equals("<") && this.dType(colNum).equals("Integer")) {
			for(int row = 0; row < this.data.get(colNum).size(); row++) {
				if (((Integer) this.data.get(colNum).get(row)).compareTo((Integer) o) < 0) {
		    			filterState.add((String) this.data.get(0).get(row));
		    			filterGender.add((String) this.data.get(1).get(row));
		    			filterYear.add((Integer) this.data.get(2).get(row));
		    			filterName.add((String) this.data.get(3).get(row));
		    			filterCount.add((Integer) this.data.get(4).get(row));
				}
			}
		}
		result.data.add(filterState);
		result.data.add(filterGender);
		result.data.add(filterYear);
		result.data.add(filterName);
		result.data.add(filterCount);
		result.setColNames(this.getColNames());
		result.setColTypes(this.colTypes);
		return(result);
	}
	
	public MyDataFrame loc(int index) {
		MyDataFrame result = new MyDataFrame();
		for(int i = 0; i < this.data.size(); i++) { // for every column
			ArrayList<?> subset  =  new ArrayList<>(this.data.get(i).subList(index, index + 1));
			result.data.add(subset);
		}
		result.setColNames(this.getColNames());
		result.setColTypes(this.colTypes);
	    return(result);
	}
	
	public MyDataFrame loc(int from, int to) {
		MyDataFrame result = new MyDataFrame();
		for(int i = 0; i < this.data.size(); i++) { // for every column
			ArrayList<?> subset  =  new ArrayList<>(this.data.get(i).subList(from, to));
			result.data.add(subset);
		}
		result.setColNames(this.getColNames());
		result.setColTypes(this.colTypes);
	    return(result);
	}

	
	public MyDataFrame sort(int index) {
		int[] sortedIndices = null;
		if (this.dType(index).equals("String")) {
			sortedIndices = IntStream.range(0, this.data.get(index).size())
		                .boxed().sorted((i, j) -> ((String) this.data.get(index).get(i)).compareTo((String) this.data.get(index).get(j)) )
		                .mapToInt(ele -> ele).toArray();
		}
		else if (this.dType(index).equals("Integer")) {
			sortedIndices = IntStream.range(0, this.data.get(index).size())
	                .boxed().sorted((i, j) -> ((Integer) this.data.get(index).get(i)).compareTo((Integer) this.data.get(index).get(j)) )
	                .mapToInt(ele -> ele).toArray();
		}
		MyDataFrame result = new MyDataFrame();
		ArrayList<String> filterState = new ArrayList<String> ();
	    ArrayList<String> filterGender = new ArrayList<String> ();
	    ArrayList<String> filterName = new ArrayList<String> ();
	    ArrayList<Integer> filterYear = new ArrayList<Integer>();
	    ArrayList<Integer> filterCount = new ArrayList<Integer> ();
		for( int row : sortedIndices ) {
			filterState.add((String) this.data.get(0).get(row));
			filterGender.add((String) this.data.get(1).get(row));
			filterYear.add((Integer) this.data.get(2).get(row));
			filterName.add((String) this.data.get(3).get(row));
			filterCount.add((Integer) this.data.get(4).get(row));
		}
		result.data.add(filterState);
		result.data.add(filterGender);
		result.data.add(filterYear);
		result.data.add(filterName);
		result.data.add(filterCount);
		result.setColNames(this.getColNames());
		result.setColTypes(this.colTypes);
		return result;
	}
	
	public MyDataFrame sort(String name) {
		int index = this.getColNames().get(name);
		return this.sort(index);
	}
//	
	@SuppressWarnings("unchecked")
	public Object getMin(int index) {
		if(this.dType(index).equals("Integer")) {
			return Collections.min((ArrayList<Integer>)(ArrayList<?>) this.slice(index).data.get(0));
		}
		return Collections.min((ArrayList<String>)(ArrayList<?>) this.slice(index).data.get(0));
	}
	
	@SuppressWarnings("unchecked")
	public Object getMin(String label) {
		if(this.dType(label).equals("Integer")) {
			return Collections.min((ArrayList<Integer>)(ArrayList<?>) this.slice(label).data.get(0));
		}
		return Collections.min((ArrayList<String>)(ArrayList<?>) this.slice(label).data.get(0));
	}
	
	@SuppressWarnings("unchecked")
	public Object getMax(int index) {
		if(this.dType(index).equals("Integer")) {
			return Collections.max((ArrayList<Integer>)(ArrayList<?>) this.slice(index).data.get(0));
		}
		return Collections.max((ArrayList<String>)(ArrayList<?>) this.slice(index).data.get(0));
	}
	
	@SuppressWarnings("unchecked")
	public Object getMax(String label) {
		if(this.dType(label).equals("Integer")) {
			return Collections.max((ArrayList<Integer>)(ArrayList<?>) this.slice(label).data.get(0));
		}
		return Collections.max((ArrayList<String>)(ArrayList<?>) this.slice(label).data.get(0));
	} 

	
}
