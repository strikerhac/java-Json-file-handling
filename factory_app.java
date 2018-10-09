package aplab2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import java.util.*;

public class factory_app {
	
	public static void main(String[] args) {
		List<student> students = new ArrayList<student>();
		int choice = 0;
		System.out.println("To add a student press 1:");
		System.out.println("To delete a student press 2:");
		System.out.println("To display student list 3:");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		
		
		
		if(choice == 1) {
		String space = scanner.nextLine();
		System.out.println("Student first name:");
		String fname = scanner.nextLine();
		System.out.println("Student last name:");
		String lname = scanner.nextLine();
		System.out.println("Student DOB:");
		String DOB = scanner.nextLine();
		System.out.println("Student address:");
		String address = scanner.nextLine();
		System.out.println("Student class name:");
		String cname = scanner.nextLine();
		student s = null;
		try {
		s = student_factory.createstudent(fname,lname,DOB,address,cname);
		
		} catch (Exception e) {
		       e.printStackTrace();
		}
	
		File file = student_singelton.getFile();
        FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		FileOutputStream fop = null;
		try {
			fop = new FileOutputStream(file,true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			SequenceWriter seqWriter = mapper.writer().writeValues(fileWriter);
			seqWriter.write(s);
			fop.write("\n".getBytes());
	        seqWriter.close();
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(choice == 2) {
			System.out.print("Enter the first name of student: ");
			String firstname = scanner.nextLine();
			
			File file = student_singelton.getFile();
			ObjectMapper mapper = new ObjectMapper();
			
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  
			String stud;
			try {
				while ((stud = br.readLine()) != null) {
					students.add(mapper.readValue(stud, student.class));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Search in the list of students to match the firstName and then removes the student from List
			boolean removed = false;
			Iterator<student> iter = students.iterator();
			while (iter.hasNext()) {
			   student s = iter.next();
			   if(s.getfname().equals(firstname)) {
				   iter.remove();
				   removed = true;
				   break;
			   }
			}
			
			//Checks if the student is not removed then prompt the user
			if(removed == false) {
				System.out.println("\nThis student is not listed");
				return;
			}
			System.out.println("\nStudent deleted successfully !");
			
			FileOutputStream fop = null;
			try {
				fop = new FileOutputStream(file,true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(file, true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			writer.print("");
			
			SequenceWriter seqWriter;

			for(student student: students) {
				try {
					seqWriter = mapper.writer().writeValues(fileWriter);
					seqWriter.write(student);
					fop.write("\n".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(choice == 3) {
			JsonReader reader = null;
			try {
				reader = Json.createReader(new FileReader("C:\\Users\\Hassaan Akbar Cheema\\Documents\\AP\\student.json"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    JsonArray jsonArray = (JsonArray) reader.read(); 
		    System.out.println(jsonArray);
		}
		

	}
	public static String toString(student s){ 
	     return "First_Name: " + s.getfname() + " Last_Name: " + s.getlname() + "Birthday: "
	            + s.getDOB() + "Address: " + s.getaddress() + "Class_Name: " + s.getclassname() + " " ;
	} 
}