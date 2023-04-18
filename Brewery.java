import java.util.ArrayList;

public class Brewery implements SysOut {
    ArrayList<Employee> employeeList;
    ArrayList<Employee> departedEmployees;
    ArrayList<Beer> beerInStock;
    ArrayList<Beer> soldBeer;
    public double budget;

    Enums.DayOfWeek simDay;
    
    Brewery(){
        employeeList = new ArrayList<>();
        departedEmployees = new ArrayList<>();
        beerInStock = new ArrayList<>();
        soldBeer = new ArrayList<>();

        budget = 100000;
    }
    double getBudget(){
        return budget;
    }
    void moneyIn(double income){
        budget += income;
    }
    void moneyOut(double cash){
        budget -= cash;
        if(budget < 0){
            budget += 250000;
            out("*** Budget overrun *** Added $250K, current budget: " + Utility.asDollar(budget));
        }
    }
    ArrayList<Customer> getCustomers(Enums.DayOfWeek day){
        int cusMin = 0;
        int cusMax = 20;

        if (day == Enums.DayOfWeek.Mon || day == Enums.DayOfWeek.Wed){
            cusMin = 10; 
            cusMax= 50;
        }

        ArrayList<Customer> customers = new ArrayList<Customer>();
        int customerCount = Utility.rndFromRange(cusMin, cusMax);
        for (int i=1; i<=customerCount; ++i) customers.add(new Customer());
        out("The FNCD has "+customerCount+" buyers today...");

        return customers;
    }
    void hireEmployees(){

    }
    void addEmployee(Enums.StaffType t){

    }
    void restockBeer(){

    }

    void payEmployees(){

    }

    void checkForQuitters(){

    }
    void checkForMisbehavior(){

    }

    void happyHourAllDay(Enums.DayOfWeek day){

    }

    void normalDay(Enums.DayOfWeek day){
        out("Nebula Brewing Co. is opening...");

        hireEmployees();
        restockBeer();

        out("The servers are attending tables");
        ArrayList<Employee> servers = Employee.getStaffByType(employeeList, Enums.EmployeeType.Server);
        for(Employee e : servers){
            Server s = (Server) s;
            s.serveTables();
        }
    }
    void reportOut(Enums.DayOfWeek day){

    }
}