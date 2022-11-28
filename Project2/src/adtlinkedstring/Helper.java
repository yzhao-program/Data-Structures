package adtlinkedstring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Helper class for the driver program.
 * @author ylzhao
 * @version 1.0
 */
public class Helper {
	/**
	 * Demonstrates and tests the reference based Linked String.
	 * @throws FileNotFoundException If a file is not found
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index >= length()
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	public static void start() throws FileNotFoundException, LinkedStringIndexOutOfBoundsException, LinkedStringException {
		ArrayList<LinkedString> arrayList = new ArrayList<LinkedString>();
		// Create a list
		create(arrayList);
		// Display a list
		displayAndMore(arrayList);
		
	}
	
	/**
	 * Creates a list of linked strings.
	 * @param arrayList A reference to a list of linked strings
	 * @throws FileNotFoundException If a file is not found
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	private static void create(ArrayList<LinkedString> arrayList) throws FileNotFoundException, LinkedStringException {
		Scanner input = new Scanner(new File("testdata2.txt"));
		// Set a flag variable to use some testing data as strings and some as character arrays to test all constructors
		int constructorTag = 0;
		while(input.hasNext()) {
			if (constructorTag % 2 == 0) {
				// Test LinkedString(String charStr) constructor
				arrayList.add(new LinkedString(input.next()));
//				System.out.println("string");
			} else {
				// Test LinkedString(char[] charArr) constructor
				arrayList.add(new LinkedString(input.next().toCharArray()));
//				System.out.println("char array");
			}
			constructorTag++;
		}
		input.close();
	}
	
	/**
	 * Displays linked string and other test results in order.
	 * @param list A reference to a list of linked strings
	 * @throws LinkedStringIndexOutOfBoundsException If index < 0 or index >= length()
	 * @throws LinkedStringException If length() is 0 (If Linked String is empty)
	 */
	private static void displayAndMore(ArrayList<LinkedString> list) throws LinkedStringIndexOutOfBoundsException, LinkedStringException{
		for (int i = 0; i < list.size() - 1; i++) {
			if ( (!list.get(i).isEmpty()) && (!list.get(i+1).isEmpty()) ) {
				
				System.out.println("The Length of each linked string:");
				System.out.println(list.get(i).length());
				System.out.println(list.get(i+1).length());
				
				System.out.println("The first character of each linked string:");
				System.out.println(list.get(i).charAt(0));
				System.out.println(list.get(i+1).charAt(0));
				
				System.out.println("Call substring to get the first character of each linked string:");
				System.out.println(list.get(i).substring(0, 1));
				System.out.println(list.get(i+1).substring(0, 1));
				
				System.out.println("Call concat to get concated linked string:");
				System.out.println(list.get(i).concat(list.get(i+1)));
				
				System.out.println();
			}
		}
	}

}
