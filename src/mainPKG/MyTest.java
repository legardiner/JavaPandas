package mainPKG;
import java.io.FileNotFoundException;


public class MyTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MyPandas pandas = new MyPandas();
		MyDataFrame test = pandas.readCSV("/Users/sarahgreenwood/Desktop/testbaby.csv"); 
		System.out.print(test.getName());
	}

}
