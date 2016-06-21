import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapApp {

	public static void main(String[] args) {
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		myMap = readNumbers(myMap);
		
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter Number (-1 to exit): ");
			int input = in.nextInt();
			in.nextLine();
			if(input==-1)break;
			if(myMap.containsKey(input))System.out.println("You entered " + myMap.get(input));
			else{
				System.out.println("Enter spelling: ");
				String spelling = in.nextLine();
				myMap.put(input,spelling);
			}
		}
		
		writeNumbers(myMap);
			
	}
	
	public static void writeNumbers(HashMap<Integer, String> numbers) {
		System.out.println((System.getProperty("user.dir") + File.separatorChar +"mynumbers.txt"));
		String filename = (System.getProperty("user.dir") + File.separatorChar +"mynumbers.txt");
		
		
		 
		try (PrintWriter writer = new PrintWriter(new File(filename))) {
			
			//writer = new PrintWriter(new File(filename));
			Set<Integer> number = numbers.keySet();
			
			for(Integer numAsNumber : number) {
				String numberInWords = numbers.get(numAsNumber);
				writer.println(numAsNumber + " " + numberInWords);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
	public static HashMap<Integer,String> readNumbers(HashMap<Integer, String> numbers) {
String filename = (System.getProperty("user.dir") + File.separatorChar +"mynumbers.txt");
		
		File file = new File(filename);
		
        try(Scanner scannerInput = new Scanner(file)){
        while (scannerInput.hasNextLine()) {
        	int numInt = scannerInput.nextInt();
            String numStr = scannerInput.next();
            numbers.put(numInt, numStr);
            scannerInput.nextLine();
        }
        }catch (IOException e) {
			System.out.println(e.getMessage());
        }

		return numbers;
	}
}
