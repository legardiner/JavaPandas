package mainPKG;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class MyTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		// TODO Auto-generated method stub
		MyPandas pandas = new MyPandas();
		MyDataFrame test = pandas.readCSV("/Users/sarahgreenwood/Desktop/testbaby.csv"); 
		System.out.println(test.getCol1());
		System.out.println(test.tail(5).getCol4());
		System.out.println(test.getCol3().get(4).getClass());
		System.out.println(test.getColNames());
		System.out.println(test.slice("name").getCol3());
		
		

		
		
		
//		pandas.writeCSV(test, "/Users/sarahgreenwood/Desktop/test.csv");
//		System.out.println(test.getCount());
//		System.out.println(test.tail(5).getCount());
//		System.out.println(test.getCount().size());
//		System.out.println(test.dType(1));
//		System.out.println(test.dType("year"));
//		System.out.println(test.loc(2).getName());
//		System.out.println(test.loc(0, 4).getName());
		
	}

}
