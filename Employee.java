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
        pay = 60.00;
    }
    Beer serveBeer(Customer c, ArrayList<Beer> beerInStock){
        double saleChance = .7;
        if(c.type == Enums.CustomerType.WantsOne) saleChance = .8;
        if(c.type == Enums.CustomerType.JustLooking) saleChance = .2;

        ArrayList<Beer> desiredList = Beer.getBeerByType(beerInStock, c.preference);
        Beer b;

        b = getMostExpensiveBeer(desiredList);

        if(b == null){
            saleChance -= .2;
            b = getMostExpensiveBeer(beerInStock);
        }

        else{
            double chance = Utility.rnd();
            if (chance <= saleChance){
                if (chance <= .25){ // buyer got two of this beer
                    Double sellPrice = b.price;
                    sellPrice += b.price;
                }

                if (chance <= .08){ // buyer got four beers, round on him!
                    Double sellPrice = b.price; 
                    sellPrice += b.price * 4;
                }
                
                if (chance <= .02){ // ok, buyer had a big party today. 6 beers
                    Double sellPrice = b.price;
                    sellPrice += b.price * 6;
                }
            }
            else{ // no sale for this customer
                out("Customer " + b.name + " decided not to get any beers today.");
                return null;
            }
        }
        //Beer b = beerInStock.get(0);

        if(c.preference == Enums.BeerType.IPA) saleChance += .1; // TODO Find a way to have customer buy a specific kind of beer.
        if(c.preference == Enums.BeerType.Stout) saleChance += .1;
        if(c.preference == Enums.BeerType.Lager) saleChance += .1;
        if(c.preference == Enums.BeerType.Sour) saleChance += .1;
        if(c.preference == Enums.BeerType.Porter) saleChance += .1;
        if(c.preference == Enums.BeerType.Ale) saleChance += .1;

        double chance = Utility.rnd();

        if (chance <= saleChance){ // TODO: Customer needs to buy a specfic beer from the inventory and you can reduce the ounces and add to beers sold to that specfic beer 
            out("Customer "+c.name+" got his beer from "+name);
            return b;
        }
        else{
            out("Customer " + c.name + " decided not to buy a drink.");
            return null;
        }

    }
    
    Beer getMostExpensiveBeer(ArrayList<Beer> bList)
    {
        double highPrice = 0;
        int selected = -1;
        for (int index = 0; index< bList.size(); index++) 
        {
            Beer b = bList.get(index);
            if (b.price>highPrice) 
            {
                selected = index;
                highPrice = b.price;
            }
        }
        if (selected == -1) return null;
        else return bList.get(selected);
    }
}