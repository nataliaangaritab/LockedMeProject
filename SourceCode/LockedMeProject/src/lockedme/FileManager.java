package lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager
{
	
	/**
	 * Method will return file names from the folder (folderpath).
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getFiles(String folderpath)
	{
		//Create file object
		File newfile = new File(folderpath);
		
		//Get all the files into FileArray
		File[] listOfFiles = newfile.listFiles();
		
		//Declare list to store file names
		List<String> fileNames = new ArrayList<String>();
		Collections.sort(fileNames);
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
		//Return the List
		return fileNames;
	}
	
	/**
	 * Method will create or append content into the file specified.
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean createFile(String folderpath, String fileName, List<String> content)
	{
		try
		{
			File newfile = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(newfile);
			
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * Method will delete the file name if it exists.
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderpath, String fileName)
	{
		//Add folderpath with file name and create file object
		File file = new File(folderpath + "\\" + fileName);
		
		try
		{
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * Method will search for a file specified by the user.
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		File file = new File(folderpath + "\\" + fileName);
		
		if(file.exists())
			return true;
		else
			return false;
	}
}