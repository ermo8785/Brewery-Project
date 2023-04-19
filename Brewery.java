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

        BeerFactory beerFactory = new BeerFactory(beerInStock);
        beerFactory.addMoreBeer("IPA").importBeer();
        beerFactory.addMoreBeer("Porter").importBeer();
        beerFactory.addMoreBeer("Stout").importBeer();
        beerFactory.addMoreBeer("Lager").importBeer();
        beerFactory.addMoreBeer("Sour").importBeer();
        beerFactory.addMoreBeer("Ale").importBeer();

        Employee newEmployee = new Bartender();
        employeeList.add(newEmployee);
        employeeList.add(newEmployee);
        employeeList.add(newEmployee);
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
        out("Nebula Brewing Co. has "+customerCount+" buyers today...");

        return customers;
    }
    void hireEmployees(){

    }
    void addEmployee(Enums.EmployeeType t){

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
        out("Nice! Happy Hour All Day!");
    }

    void normalDay(Enums.DayOfWeek day){
        out("Nebula Brewing Co. is opening...");

        hireEmployees();
        restockBeer();

        out("The bartenders are serving customers...");
        
        ArrayList<Customer> customers = getCustomers(day);
        ArrayList<Employee> bartenders =  Employee.getEmployeesByType(employeeList, Enums.EmployeeType.Bartender);

        for (Customer c : customers){
            out("Customer "+c.name+" wants a "+c.preference);
            int randomBartender = Utility.rndFromRange(0, bartenders.size()-1);
            Bartender bartender = (Bartender) bartenders.get(randomBartender);
            Beer beerSold = bartender.serveBeer(c, beerInStock);

            if(beerSold != null){
                soldBeer.add(beerSold);
                moneyIn(beerSold.price);
                beerInStock.removeIf(n -> n.name == beerSold.name);

                beerInStock.add(beerSold);
                moneyOut(beerSold.cost);
            }
        }
    }
    void reportOut(Enums.DayOfWeek day){
        
    }
}