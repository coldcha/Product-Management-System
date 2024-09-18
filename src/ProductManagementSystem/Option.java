package ProductManagementSystem;

import java.util.Scanner;

public interface Option {

    abstract String toString();
    abstract void oper(Database database, Scanner s, Employee e);


}