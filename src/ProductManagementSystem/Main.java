package ProductManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Product Warehouse!");
        System.out.println("Enter your email:");
        String email = s.next();
        System.out.println("Enter your password:");
        String password = s.next();
        Database database = new Database();
        String select = "SELECT * FROM Employees WHERE Email = '"+email+"' AND Password = '"+password+"';";

        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            if (rs.next()){
                Employee e;
                int job = rs.getInt("Job");
                switch(job){
                    case 1:
                        e = new Manager();
                        break;
                    case 2:
                        e = new Worker();
                        break;
                    case 3:
                        e = new Cashier();
                        break;
                    default:
                        e = new Employee(){};
                        break;
                }
                e.setID(rs.getInt("ID"));
                e.setFirstName(rs.getString("First Name"));
                e.setLastName(rs.getString("Last Name"));
                e.setEmail(rs.getString("Email"));
                e.setPhoneNumber(rs.getString("PhoneNumber"));
                e.setPassword(rs.getString("Password"));
                e.setSalary(rs.getDouble("Salary"));
                e.setDateOfBirth(rs.getString("DateOfBirth"));
                e.setWorkHours(rs.getInt("WorkHours"));
                e.setStartTime(rs.getString("StartTime"));
                e.setEndTime(rs.getString("EndTime"));
                e.showOptions(database, s);
            } else {
                System.out.println("Incorrect email or password!");
                System.out.println("Application Closing..");
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}