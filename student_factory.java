package aplab2;
public class student_factory {

	public static student createstudent(String firstname, String lastname, String DOB, String address, String classname) throws Exception {
		
			return new student(firstname,lastname,DOB,address,classname);
		} 
		
		

}