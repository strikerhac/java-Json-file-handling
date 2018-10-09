package aplab2;

import java.io.File;
import java.io.IOException;

public class student_singelton {
	//A static object that is shared among all the classes following the Singleton pattern
	//Its purpose is to return the same reference to a single file whenever it is required
	private static student_singelton studentFile = new student_singelton();
	private File file;
	private student_singelton() {}
	//Returns already existing file or creates new file first time
	public File getFileObject() {
		file = new File("C:\\Users\\Hassaan Akbar Cheema\\Documents\\AP\\student.json");
		
		try {
			if(file.createNewFile()) {
				return file;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	//Returns a static reference to a File object following the Singleton pattern
	public static File getFile() {
		return studentFile.getFileObject();
	}
}
