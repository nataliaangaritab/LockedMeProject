package lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager
{
	public static List<String> getFiles(String folderpath)
	{
		//Create file object
		File newfile = new File(folderpath);
		
		//Get all the files into FileArray
		File[] listOfFiles = newfile.listFiles();
		
		//Declare list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
		//Return the List
		return fileNames;
	}
}