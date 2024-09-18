package ProductManagementSystem;

public class Manager extends Employee{
    public Manager(){
        super();
        this.options = new Option[]{
                new CreateEmployee()
        };

    }
}
