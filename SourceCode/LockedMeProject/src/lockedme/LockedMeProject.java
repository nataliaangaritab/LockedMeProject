package lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject
{
	//Create path variable
	static final String folderpath="C:\\Users\\natal\\Desktop\\Simplilearn\\Phase1-LockedMeProject\\Files";
	public static void main(String[] args)
	{
		//Variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		//Read file name from user
		System.out.println("Enter file name: ");
		fileName = obj.nextLine();
		
		//Read number of lines from user
		System.out.println("Enter number of lines in the file: ");
		linesCount = Integer.parseInt(obj.nextLine());
		
		//Read lines from user
		for(int i=1; i<=linesCount; i++)
		{
			System.out.println("Enter line " + i + ": ");
			content.add(obj.nextLine());
		}
		
		//Save content into the file
		boolean isSaved = FileManager.createFile(folderpath, fileName, content);
		if(isSaved)
			System.out.println("File and data saved successfully!");
		else
			System.out.println("Some error ocurred. Please contact Support !!!");
		
		//Close Scanner object
		obj.close();
	}
}