package lockedme;

import java.util.List;

public class LockedMeProject
{

	//Path
	static final String folderpath="C:\\Users\\natal\\Desktop\\Simplilearn\\Phase1-LockedMeProject\\Files";
	public static void main(String[] args)
{
		List<String> fileNames = FileManager.getFiles(folderpath);
		for(String f:fileNames)
			System.out.println(f);
	}

}