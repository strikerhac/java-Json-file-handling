student database model have four classes:
> factory_app
> student_factory
> student_singelton
> student

student object is created using the factory method
factory app has a main method. It uses student factory to create a student object and stores the object in a json file. 
It also have add delete and display functionality.
Student singleton class ensures that the file is created only once and then shared to all other classes.
Student class contains attributes of student and a constructor that creates the student.
Student factory has a create student method that returns a student object

