package mainPKG;
import java.util.ArrayList;
import java.util.HashMap;



public class MyDataFrame {
    
    private ArrayList<Object> col0; 
    private ArrayList<Object> col1;
    private ArrayList<Object> col2;
    private ArrayList<Object> col3;
    private ArrayList<Object> col4;
    HashMap<String,Integer> colNames = new HashMap<String,Integer>();
    
    public MyDataFrame() {
    		this.col0 = null;
    		this.col1 = null;
    		this.col2 = null;
    		this.col3 = null;
    		this.col4 = null; 
    		this.colNames = null;
    }
    
    public MyDataFrame(ArrayList<Object> col0, ArrayList<Object> col1, ArrayList<Object> col2, 
    		ArrayList<Object> col3, ArrayList<Object> col4, HashMap<String,Integer> colNames) {
    		this.col0 = col0;
    		this.col1 = col1;
    		this.col2 = col2;
    		this.col3 = col3;
    		this.col4 = col4; 
    		this.colNames = colNames;
    }
    public ArrayList<Object> getCol0() {
		return(this.col0);
    }
    public ArrayList<Object> getCol1() {
		return(this.col1);
    }
    public ArrayList<Object> getCol2() {
		return(this.col2);
    }
    public ArrayList<Object> getCol3() {
		return(this.col3);
    }
    public ArrayList<Object> getCol4() {
		return(this.col4);
    }
    public HashMap<String,Integer> getColNames() {
		return(this.colNames);
    }
    
    private void setCol0(ArrayList<Object> col) {
    		this.col0 = col;
    }
    private void setCol1(ArrayList<Object> col) {
		this.col1 = col;
    }
    private void setCol2(ArrayList<Object> col) {
		this.col2 = col;
    }
    private void setCol3(ArrayList<Object> col) {
		this.col3 = col;
    }
    private void setCol4(ArrayList<Object> col) {
		this.col4 = col;
    }
    
	public MyDataFrame head(int n) {
		ArrayList<Object> col0 = new ArrayList<Object>(this.col0.subList(0, n));
		ArrayList<Object> col1 = new ArrayList<Object>(this.col1.subList(0, n));
		ArrayList<Object> col2 = new ArrayList<Object>(this.col2.subList(0, n));
		ArrayList<Object> col3 = new ArrayList<Object>(this.col3.subList(0, n));
		ArrayList<Object> col4 = new ArrayList<Object>(this.col4.subList(0, n));
	    
		return new MyDataFrame(col0, col1, col2, col3, col4, this.getColNames());
	}
	
	public MyDataFrame tail(int n) {
		ArrayList<Object> col0 = new ArrayList<Object>(this.col0.subList(this.col0.size()-n, this.col0.size()));
		ArrayList<Object> col1 = new ArrayList<Object>(this.col1.subList(this.col1.size()-n, this.col1.size()));
		ArrayList<Object> col2 = new ArrayList<Object>(this.col2.subList(this.col2.size()-n, this.col2.size()));
		ArrayList<Object> col3 = new ArrayList<Object>(this.col3.subList(this.col3.size()-n, this.col3.size()));
		ArrayList<Object> col4 = new ArrayList<Object>(this.col4.subList(this.col4.size()-n, this.col4.size()));
		
		return new MyDataFrame(col0, col1, col2, col3, col4, this.getColNames());
	}

	/*
	public String dType(int index) {
		String[] columns = {"String", "String", "Integer", "String", "Integer"};
		if(index > 5 | index < 0 ) {
			return "Not a valid index.";
		}
		return columns[index];
	}
	

	public String dType(String name) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("state","String");
		hashtable.put("gender","String");
		hashtable.put("name","String");
		hashtable.put("year","Integer");
		hashtable.put("count","Integer");
		if(!hashtable.containsKey(name)) {
			return "Not a valid index.";
		}
		return hashtable.get(name);
	}*/

	public MyDataFrame slice(int index) {
		MyDataFrame result = new MyDataFrame();
		if(index == 0) {
			result.setCol0(this.col0);
		}
		if(index == 1) {
			result.setCol1(this.col1);
		}
		if(index == 2) {
			result.setCol2(this.col2);
		}
		if(index == 3) {
			result.setCol3(this.col3);
		}
		if(index == 4) {
			result.setCol4(this.col4);
		}
		return result;
	}	
		
	public MyDataFrame slice(String name) {
		MyDataFrame result = new MyDataFrame();
		int index = this.getColNames().get(name);
		if(index == 0) {
			result.setCol0(this.col0);
		}
		if(index == 1) {
			result.setCol1(this.col1);
		}
		if(index == 2) {
			result.setCol2(this.col2);
		}
		if(index == 3) {
			result.setCol3(this.col3);
		}
		if(index == 4) {
			result.setCol4(this.col4);
		}
		return result;
	}
	
	public MyDataFrame slice(int[] indexArr) {
		MyDataFrame result = new MyDataFrame();
		for(int index: indexArr) {
			if(index == 0) {
				result.setCol0(this.col0);
			}
			if(index == 1) {
				result.setCol1(this.col1);
			}
			if(index == 2) {
				result.setCol2(this.col2);
			}
			if(index == 3) {
				result.setCol3(this.col3);
			}
			if(index == 4) {
				result.setCol4(this.col4);
			}
		}
		return result;
	}

	public MyDataFrame slice(String[] nameArr) {
		MyDataFrame result = new MyDataFrame();
		for(String index: nameArr) {
			if(this.getColNames().get(index) == 0) {
				result.setCol0(this.col0);
			}
			if(this.getColNames().get(index) == 1) {
				result.setCol1(this.col1);
			}
			if(this.getColNames().get(index) == 2) {
				result.setCol2(this.col2);
			}
			if(this.getColNames().get(index) == 3) {
				result.setCol3(this.col3);
			}
			if(this.getColNames().get(index) == 4) {
				result.setCol4(this.col4);
			}
		}
	return result;
}
//	
//	public MyDataFrame filter(String col, String op, Object o) {
//		return filteredData;
//	}
//	
	public MyDataFrame loc(int index) {
	    ArrayList<Object> col0 = new ArrayList<Object>();
	    ArrayList<Object> col1 = new ArrayList<Object> ();
	    ArrayList<Object> col2 = new ArrayList<Object> ();
	    ArrayList<Object> col3 = new ArrayList<Object> ();
	    ArrayList<Object> col4 = new ArrayList<Object> ();
	    
	    
	    col0.add(this.col0.get(index));
	    col1.add(this.col1.get(index));
	    col2.add(this.col2.get(index));
	    col3.add(this.col3.get(index));
	    col4.add(this.col4.get(index));

	    return(new MyDataFrame(col0, col1, col2, col3, col4, this.getColNames()));
	}
	
	public MyDataFrame loc(int from, int to) {
		ArrayList<Object> col0 = new ArrayList<Object>(this.col0.subList(from, to));
		ArrayList<Object> col1 = new ArrayList<Object>(this.col1.subList(from, to));
		ArrayList<Object> col2 = new ArrayList<Object>(this.col2.subList(from, to));
		ArrayList<Object> col3 = new ArrayList<Object>(this.col3.subList(from, to));
		ArrayList<Object> col4 = new ArrayList<Object>(this.col4.subList(from, to));
	    
		return new MyDataFrame(col0, col1, col2, col3, col4, this.getColNames());
	}

//	
//	public MyDataFrame sort(int index) {
//		return sortedData;
//	}
//	
//	public MyDataFrame sort(String name) {
//		return sortedData;
//	}
//	
//	public Object getMin(int index) {
//		Object min; 
//		return min;
//	}
//	
//	public Object getMin(String label) {
//		return min;
//	}
//	
//	public Object getMax(int index) {
//		return max;
//	}
//	
//	public Object getMax(String label) {
//		return max;
//	} 
	
}
