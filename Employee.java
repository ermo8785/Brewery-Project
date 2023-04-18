import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public abstract class Employee implements SysOut{
    String name;
    Double pay;
    Double payEarned;
    int strikes;
    int daysWorked;
    Enums.EmployeeType type;

    public String textOut = " ";
    Employee(){
        strikes = 0;
        daysWorked = 0;
        payEarned = 0.00; 
    }

    // returns how many of each employee type there are
    static int howManyStaffByType(ArrayList<Employee> employeeList, Enums.EmployeeType t){
        int n = 0;
        for (Employee e: employeeList){
            if (e.type == t) {
                n++;
            }
        }
        return n;
    }
}

class Server extends Employee{
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    static Namer namer = new Namer(names);

    Server(){
        super();
        type = Enums.EmployeeType.Server;
        name = namer.getNext();
    }
    void serveTables(ArrayList<Customer> customerList){

    }
}

class Bartender extends Employee{
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    static Namer namer = new Namer(names);
    
    Bartender(){
        super();
        type = Enums.EmployeeType.Bartender;
        name = namer.getNext();
    }
    void tendBar(){
        
    }
}