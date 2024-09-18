package ProductManagementSystem;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Employee {

    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Double salary;
    private LocalDate dateOfBirth;
    private int workHours;
    private LocalTime startTime;
    private LocalTime endTime;
    protected Option[] options;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");


    public Employee() {}

    public int getID(){return ID;}
    public void setID(int ID){this.ID=ID;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName=firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName=lastName;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getPhoneNumber(){return phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public double getSalary(){return salary;}
    public void setSalary(Double salary){this.salary=salary;}

    public String getDateOfBirth(){return dateFormatter.format(dateOfBirth);}
    public void setDateOfBirth(String dateOfBirth){this.dateOfBirth = LocalDate.parse(dateOfBirth, dateFormatter);}

    public int getWorkHours(){return workHours;}
    public void setWorkHours(int workHours){this.workHours = workHours;}

    public String getStartTime(){return timeFormatter.format(startTime);}
    public void setStartTime(String startTime){this.startTime = LocalTime.parse(startTime, timeFormatter);}

    public String getEndTime(){return timeFormatter.format(endTime);}
    public void setEndTime(String endTime){this.endTime = LocalTime.parse(endTime, timeFormatter);}

    public String getDateFormat(){return "yyyy-dd-MM";}
    public String getTimeFormat(){return "HH:mm";}

    public void showOptions(Database database, Scanner s){
        for (int i=0; i<options.length;i++){
            System.out.println((i+1)+". "+options[i].toString());
        }
        int i = s.nextInt();
        options[i-1].oper(database, s, this);
        showOptions(database, s);
    }
}
