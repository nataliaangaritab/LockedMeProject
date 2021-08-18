package lockedme;

import java.util.Scanner;

public class LockedMeProject
{
	//Create path variable
	static final String folderpath="C:\\Users\\natal\\Desktop\\Simplilearn\\Phase1-LockedMeProject\\Files";
	public static void main(String[] args)
	{
		//Delete a file
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter file name to be deleted: ");
		fileName = obj.nextLine();
		
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
		if(isDeleted)
			System.out.println("File deleted successfully!!");
		else
			System.out.println("File not in folder or some access issue");
		
		//Close Scanner object
		obj.close();
	}
}