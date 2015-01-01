/**
* The <code>TreeDriver</code> class handles user interaction of TreeNode
*   
* @author Imdadul Hoq
*    e-mail: 
*    Stony Brook ID: 
*    Homework #5 CSE 214
*    
**/

import java.io.*;
import java.util.*;

public class TreeDriver {

	/**
	 * @param args
	 */
	static String label;
	static String promt;
	static String msg;
	static String childNumber;
	static String parentLabel;
	static Scanner stdin = new Scanner (System.in);
	static Tree helpTree = new Tree();
	public static void main(String[] args) throws IOException {
		String input = null;
		mainMenu();
		input = stdin.next();
		while(!input.equalsIgnoreCase("Q")){
			if (input.equalsIgnoreCase("L"))
				loadFile();
			if (input.equalsIgnoreCase("H"))
				startHelp();
			if (input.equalsIgnoreCase("T"))
				helpTree.preOrder();
			mainMenu();
			input = stdin.next();
		}
		System.out.println("Closing the program");
	}
	
	private static void startHelp() {
		helpTree.beginSession();
	}
	
	/**
	 * This method load a file and assign each line to proper string
	 * @throws IOException
	 * 				-- if the file is not found
	 */

	private static void loadFile()  throws IOException {
		String fileName;
		System.out.println("Enter the file name:\t");
		fileName = stdin.next();
		fileName = fileName+".txt";
		String line ="";
		int wait=1;
		
		try{
			Scanner getFile = new Scanner(new File(fileName));
			while(getFile.hasNextLine())
			{
				label = NonEmptyLine(getFile);
				promt = NonEmptyLine(getFile);
				msg = NonEmptyLine(getFile);
				helpTree.addNode(label, promt, msg, parentLabel);
				wait--;
				if ((wait==0)&&(getFile.hasNextLine())){		
					line = NonEmptyLine(getFile);
					StringTokenizer tkChild = new StringTokenizer(line," ",false);
				    	parentLabel = tkChild.nextToken();
				    	wait  = Integer.parseInt(tkChild.nextToken());           // find the number of the children
				}
			}
			System.out.println("File loaded sucessfully");
			getFile.close();
		}catch (IOException e){
			System.out.println("File not Found");
		}
		
	}
	
	
	/***
	 * This read an input scanner and return the next non-empty line
	 * @param fileName name of the input scanner file
	 * @return Next non-empty line
	 */
	
	public static String NonEmptyLine(Scanner fileName){
	String nonEmptyLine = "";
	String line;
	while(fileName.hasNextLine())
		{
			line = fileName.nextLine();
			if (!line.isEmpty())                   //If line in not empty
			{
				nonEmptyLine = line;
				break;
			}
		}
		return nonEmptyLine;
	}
	/**
	 * Display the main Menu of the program
	 */
	
	public static void mainMenu(){
		System.out.println("L >> Load Input File");
		System.out.println("H >> Start Help Session");
		System.out.println("T >> Traverse Tree in Pre-Order");
		System.out.println("Q >> Quit");
	}

}
