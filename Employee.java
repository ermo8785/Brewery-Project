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
    static int howManyByType(ArrayList<Employee> employeeList, Enums.EmployeeType t){
        int n = 0;
        for (Employee e: employeeList){
            if (e.type == t) {
                n++;
            }
        }
        return n;
    }
    static ArrayList<Employee> getEmployeesByType(ArrayList<Employee> employeeList, Enums.EmployeeType t) {
        ArrayList<Employee> subclassInstances = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.type == t) subclassInstances.add(e);
        }
        return subclassInstances;
    }
}

/*class Server extends Employee{
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    static Namer namer = new Namer(names);

    Server(){
        super();
        type = Enums.EmployeeType.Server;
        name = namer.getNext();
    }
    void serveTables(ArrayList<Customer> customerList){

    }
}*/

class Bartender extends Employee{
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi");
    static Namer namer = new Namer(names);
    
    Bartender(){
        super();
        type = Enums.EmployeeType.Bartender;
        name = namer.getNext();
    }
    Beer serveBeer(Customer c, ArrayList<Beer> beerInStock){
        double saleChance = .7;
        if(c.type == Enums.CustomerType.WantsOne) saleChance = .8;
        if(c.type == Enums.CustomerType.JustLooking) saleChance = .2;

        //ArrayList<Beer> desiredList = Beer.getBeerByType(beerInStock, c.preference);
        Beer b = beerInStock.get(0);

        if(c.preference == Enums.BeerType.IPA) saleChance += .1;
        if(c.preference == Enums.BeerType.Stout) saleChance += .1;
        if(c.preference == Enums.BeerType.Lager) saleChance += .1;
        if(c.preference == Enums.BeerType.Sour) saleChance += .1;
        if(c.preference == Enums.BeerType.Porter) saleChance += .1;
        if(c.preference == Enums.BeerType.Ale) saleChance += .1;

        double chance = Utility.rnd();

        if (chance <= saleChance){
            out("Customer "+c.name+" got his beer from "+name);
            return b;
        }
        else{
            out("Customer " + c.name + " decided not to buy a drink.");
            return null;
        }
    }

}