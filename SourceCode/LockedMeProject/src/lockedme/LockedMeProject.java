package lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject
{
	//Create path variable
	static final String folderpath="C:\\Users\\natal\\Desktop\\Simplilearn\\Phase1-LockedMeProject\\Files";
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args)
	{
		int menuStatus = 1;
		do
		{
			//Variable declaration
			int userChoice;
			
			//Menu
			displayMenu();
			System.out.println("Enter your choice:");
			userChoice = Integer.parseInt(obj.nextLine());
			
			switch (userChoice)
			{
				case 1:
					getFiles();
					break;
				case 2:
					createFile();
					break;
				case 3:
					deleteFile();
					break;
				case 4:
					searchFile();
					break;
				case 5:
					System.exit(0);
					break;
				default: System.out.println("Invalid Option");
			}
		} while(menuStatus > 0);
	}
	
	/**
	 * Method will display menu so user can select an option
	 */
	public static void displayMenu()
	{
		System.out.println("================================================================");
		System.out.println("\tCompany Lockers Pvt. Ltd. - LockedMe.com Project");
		System.out.println("================================================================");
		System.out.println("1. Display file names list");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit application");
		System.out.println("================================================================");
	}
	
	/**
	 * Method will get file name in a list
	 */
	public static void getFiles()
	{
		List<String> fileNames = FileManager.getFiles(folderpath);
		if (fileNames.size()==0)
			System.out.println("No files in directory");
		else
		{
			System.out.println("FILES LIST IS BELLOW:");
			for(String f:fileNames)
				System.out.println(f);
		}
	}
	
	/**
	 * Method will create a new file with specific number of lines
	 */
	public static void createFile()
	{
		//Variable declaration
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();

		// Read file name from user
		System.out.println("Enter file name: ");
		fileName = obj.nextLine();

		// Read number of lines from user
		System.out.println("Enter number of lines in the file:");
		linesCount = Integer.parseInt(obj.nextLine());

		// Read lines from user
		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			content.add(obj.nextLine());
		}

		// Save content into the file
		boolean isSaved = FileManager.createFile(folderpath, fileName, content);
		if (isSaved)
			System.out.println("File and data saved successfully!");
		else
			System.out.println("Some error ocurred. Please contact Support !!!");
	}
	
	/**
	 * Method will delete a file by name
	 */
	public static void deleteFile()
	{
		//Delete a file
		String fileName;
		System.out.println("Enter file name to be deleted:");
		fileName = obj.nextLine();
		
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
		if(isDeleted)
			System.out.println("File deleted successfully!!");
		else
			System.out.println("File not in folder or some access issue");
	}
	
	/**
	 * Method will search for a file by name
	 */
	public static void searchFile()
	{
		//Search a file
		String fileName;
		System.out.println("Enter file name to be searched:");
		fileName = obj.nextLine();
		
		boolean isFound = FileManager.searchFile(folderpath, fileName);
		if(isFound)
			System.out.println("File was found on the folder!!");
		else
			System.out.println("File not in folder");
	}
}