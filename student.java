package aplab2;
public class student extends student_factory{
	private String fname;
	private String lname;
	private String DOB;
	private String address;
	private String classname;
	
	student(String firstname, String lastname, String DOB, String address, String classname){
		this.fname = firstname;
		this.lname = lastname;
		this.DOB = DOB;
		this.address = address;
		this.classname = classname;	
	}
	
	public String getfname(){
        return this.fname;
    }

    //public method to set the age variable
    public void setfname(String fname){
        this.fname = fname;
    }
    public String getlname(){
        return this.lname;
    }

    //public method to set the age variable
    public void setlname(String lname){
        this.lname = lname;
    }
    public String getDOB(){
        return this.DOB;
    }

    //public method to set the age variable
    public void setDOB(String DOB){
        this.DOB = DOB;
    }
    public String getaddress(){
        return this.address;
    }

    //public method to set the age variable
    public void setaddress(String address){
        this.address = address;
    }
    
    public String getclassname(){
        return this.classname;
    }

    //public method to set the age variable
    public void setclassname(String classname){
        this.classname = classname;
    }
}