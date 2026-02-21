package main.java;
public class Student {

    private int studID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String course;
    private int yearLevel;
    private String section;
    private String email;
    private int contactNum;

    public Student(int studID, String firstName, String lastName, int age,
                   String gender, String course, int yearLevel,
                   String section, String email, int contactNum) {

        this.studID = studID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.yearLevel = yearLevel;
        this.section = section;
        this.email = email;
        this.contactNum = contactNum;
    }

    public int getStudID() 
    { return studID; }
    public String getFirstName() 
    { return firstName; }
    public String getLastName() 
    { return lastName; }
    public int getAge() 
    { return age; }
    public String getGender() 
    { return gender; }
    public String getCourse() 
    { return course; }
    public int getYearLevel() 
    { return yearLevel; }
    public String getSection() 
    { return section; }
    public String getEmail() 
    { return email; }
    public int getContactNum() 
    { return contactNum; }
}