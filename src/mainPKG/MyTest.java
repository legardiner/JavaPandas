package mainPKG;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;



public class MyTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MyPandas pandas = new MyPandas();
		MyDataFrame test = pandas.readCSV("babynamesample.csv"); 
		MyDataFrame test2 = pandas.readCSV("babynamesample.csv"); 
		pandas.writeCSV(test, "ahh.csv");
		String [] index = {"occurrences","sex"};
		System.out.println(test.slice(index).colTypes);
		System.out.println(test.data.get(2));
		String key = test.dType(4);
		System.out.println(key);
		MyDataFrame doubledf = pandas.concat(test, test2);
		System.out.println(doubledf.data.get(2));
		System.out.println(test.getColNames());
		System.out.println(doubledf.getColNames());
		System.out.println(test.colNames.get("sex"));
		System.out.println(test.data.get(1));
		System.out.println(test.data.get(1).get(1));
		System.out.println(test.data.get(0));
		MyDataFrame filterdf = doubledf.filter("state", "=", "AK");
		MyDataFrame filterdf2 = doubledf.filter("year", "<", 1911);
		MyDataFrame filterdf3 = doubledf.filter("name", ">", "Dorothy");
		System.out.println(filterdf.data.get(1));
		System.out.println(filterdf.data.get(0));
		System.out.println(filterdf2.data.get(1));
		System.out.println(filterdf2.data.get(2));
		System.out.println(filterdf3.data.get(1));
		System.out.println(filterdf3.data.get(3));
		MyDataFrame sortedByYear = doubledf.sort(2);
		System.out.println(sortedByYear.data.get(1));
		System.out.println(sortedByYear.data.get(2));
		MyDataFrame sortedByName = doubledf.sort(3);
		System.out.println(sortedByName.data.get(1));
		System.out.println(sortedByName.data.get(2));
		System.out.println(sortedByName.data.get(3));
//		System.out.println(test.colTypes.get(key));
		//System.out.println(test.slice(index).colTypes);

	}
}
