package mainPKG;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;



public class MyTest {

	public static void main(String[] args) throws Exception{
		// Instantiate myPandas
		MyPandas pandas = new MyPandas();
		// readCSV
		MyDataFrame test = pandas.readCSV("babynamesample.csv"); 
		MyDataFrame test2 = pandas.readCSV("babynamesample.csv"); 
		// writeCSV
		pandas.writeCSV(test, "output.csv");
		// concat
		System.out.println("");
		System.out.println("CONCAT");
		System.out.println("Original column two");
		System.out.println(test.data.get(2));
		System.out.println("Column two after concat");
		MyDataFrame doubledf = pandas.concat(test, test2);
		System.out.println(doubledf.data.get(2));
		// Head and Tail
		System.out.println("");
		System.out.println("HEAD");
		System.out.println("Original column two");
		System.out.println(test.data.get(2));
		System.out.println("Column two after head");
		MyDataFrame firstfour = doubledf.head(4);
		System.out.println(firstfour.data.get(2));
		System.out.println("");
		System.out.println("TAIL");
		System.out.println("Original column two");
		System.out.println(test.data.get(2));
		System.out.println("Column two after tail");
		MyDataFrame lastfour = doubledf.tail(4);
		System.out.println(lastfour.data.get(2));
		// dType
		System.out.println("");
		System.out.println("DTYPE");
		System.out.println("dType of column two and of state column");
		System.out.println(test.dType(2));
		System.out.println(test.dType("state"));
		// Slicing slice
		System.out.println("");
		System.out.println("SLICING");
		System.out.println("Slice columns by column name and index and show includes columns in new data frame");
		System.out.println(test.slice(1).colTypes);
		System.out.println(test.slice("sex").colTypes);
		int [] index = {1, 2};
		System.out.println(test.slice(index).colTypes);
		String [] colnames = {"occurrences","sex"};
		System.out.println(test.slice(colnames).colTypes);
		// Filtering filter
		System.out.println("");
		System.out.println("FILTERING");
		System.out.println("Original state, year, and name column");
		System.out.println(doubledf.data.get(0));
		System.out.println(doubledf.data.get(2));
		System.out.println(doubledf.data.get(3));
		System.out.println("State and name column before and after filter on state = AK");
		MyDataFrame filterdf = doubledf.filter("state", "=", "AK");
		System.out.println(filterdf.data.get(0));
		System.out.println(filterdf.data.get(3));
		System.out.println("Year and column before and after filter year < 1911");
		MyDataFrame filterdf2 = doubledf.filter("year", "<", 1911);
		System.out.println(filterdf2.data.get(2));
		System.out.println(filterdf2.data.get(3));
		System.out.println("Year and name column before after filter name > Dorothy");
		MyDataFrame filterdf3 = doubledf.filter("name", ">", "Dorothy");
		System.out.println(filterdf3.data.get(2));
		System.out.println(filterdf3.data.get(3));
		// Indexing loc
		System.out.println("");
		System.out.println("INDEXING");
		System.out.println("Original name column");
		System.out.println(doubledf.data.get(3));
		MyDataFrame row2 = doubledf.loc(2);
		System.out.println("Name column after indexing on row 3 (index 2) with loc");
		System.out.println(row2.data.get(3));
		MyDataFrame middlerows = doubledf.loc(2, 5);
		System.out.println("Name column after indexing on row 3 through 5 (index 2 through 5) with loc");
		System.out.println(middlerows.data.get(3));
		// Sorting sort
		System.out.println("");
		System.out.println("SORTING");
		System.out.println("Orignial dataframe");
		System.out.println(doubledf.data.get(2));
		System.out.println(doubledf.data.get(3));
		System.out.println("Sorted by year");
		MyDataFrame sortedByYear = doubledf.sort(2);
		System.out.println(sortedByYear.data.get(2));
		System.out.println(sortedByYear.data.get(3));
		System.out.println("Sorted by name");
		MyDataFrame sortedByName = doubledf.sort("name");
		System.out.println(sortedByName.data.get(2));
		System.out.println(sortedByName.data.get(3));
		// Aggregation get min
		System.out.println("");
		System.out.println("GETMIN");
		System.out.println("Get minimum year");
		System.out.println(doubledf.getMin("year"));
		System.out.println("Get minimum name");
		System.out.println(doubledf.getMin(3));
		System.out.println("Get maximum year");
		System.out.println(doubledf.getMax("year"));
		System.out.println("Get maximum name");
		System.out.println(doubledf.getMax(3));
	}
}
