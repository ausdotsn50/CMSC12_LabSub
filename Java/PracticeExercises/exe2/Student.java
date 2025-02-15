/*
    Access Levels and Modifiers
        public - accessible for ALL classes
        private - accessible within declared class

    Variables
        local - inside methods, constructors, blocks
        instance - within class, outside method
        class - within class, outside method, with STATIC keyword
*/

public class Student {
    // these are instance variables
    /* instance variables belong to an instance of the class, 
    meaning each Student object will have its own copy of these variables. */
    private String name; // within Student only
    private int age;
    private int studentNumber;
    private String course;

    // this is a class variable because of 'static keyword'
    // shared among all instances, modifying it affects ALL instances/objects
    private static String college = "UPTC"; 

    // this is a constructor
    // constructor is used to create instance of a class
    public Student(String name, int age, int studentNumber, String course) {
        // use of the 'this' keyword is to eliminate confusion between CLASS ATTRIBUTES and PARAMETERS
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.course = course;
    }

    // these are METHODS
    public String getName() {
        // returns the value of a private instance variable
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public String getCourse() {
        return course;
    }

    public static String getCollege(){
        return college;
    }
}