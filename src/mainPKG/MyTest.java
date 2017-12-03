package mainPKG;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;



public class MyTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		// TODO Auto-generated method stub
		MyPandas pandas = new MyPandas();
		MyDataFrame test = pandas.readCSV("/Users/sarahgreenwood/Desktop/testbaby.csv"); 
		pandas.writeCSV(test, "/Users/sarahgreenwood/Desktop/ahh.csv");
		String [] index = {"occurrences","sex"};
		System.out.println(test.slice(index).colTypes);
		//System.out.println(test.slice(index).colTypes);

	}
}
