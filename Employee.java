// Importing necessary Java libraries
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// An abstract class representing an Employee
public abstract class Employee implements SysOut{
    // Class fields
    String name;
    Double pay;
    Double payEarned;
    int strikes;
    int daysWorked;
    Enums.EmployeeType type;

    public String textOut = " ";
    
    // Default constructor
    Employee(){
        strikes = 0;
        daysWorked = 0;
        payEarned = 0.00; 
    }

    // Returns the number of employees of a given type in the given list.
    // Also an implementation of the Iterator pattern.
    static int howManyByType(ArrayList<Employee> employeeList, Enums.EmployeeType t){
        int n = 0;
        for (Employee e: employeeList){
            if (e.type == t) {
                n++;
            }
        }
        return n;
    }

    // Returns a list of all employees of a given type in the given list.
    // Also an implementation of the Iterator pattern.
    static ArrayList<Employee> getEmployeesByType(ArrayList<Employee> employeeList, Enums.EmployeeType t) {
        ArrayList<Employee> subclassInstances = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.type == t) subclassInstances.add(e);
        }
        return subclassInstances;
    }
}

// A class representing a Bartender, which is a type of Employee
class Bartender extends Employee{
    // Class fields
    static List<String> names = Arrays.asList("Fred","Ethel","Lucy","Desi", "Eric", "Jokic", "Micheal", "Aaron", "Jamal");
    static Namer namer = new Namer(names);
    
    // Default constructor
    Bartender(){
        super();
        type = Enums.EmployeeType.Bartender;
        name = namer.getNext();
        pay = 60.00;
    }
    
    // Method for serving beer to a customer, given a list of available beers
    Beer serveBeer(Customer c, ArrayList<Beer> beerInStock){
        // Set initial sale chance to 70%
        double saleChance = .7;
        
        // Adjust sale chance based on customer type
        if(c.type == Enums.CustomerType.WantsOne) saleChance = .8;
        if(c.type == Enums.CustomerType.JustLooking) saleChance = .2;

        // Get a list of all beers in stock that match the customer's preference
        ArrayList<Beer> desiredList = Beer.getBeerByType(beerInStock, c.preference);
        Beer b;

        // Get the most expensive beer from the desired list
        b = getMostExpensiveBeer(desiredList);

        // If no desired beer is available, reduce sale chance and get the most expensive beer overall
        if(b == null){
            saleChance -= .2;
            b = getMostExpensiveBeer(beerInStock);
        }

        // If a desired beer is available, adjust sale price based on chance and other factors
        else{
            double chance = Utility.rnd();
            if (chance <= saleChance){
                if (chance <= .25){ // Buyer got two of this beer
                    Double sellPrice = b.price;
                    sellPrice += b.price;
                }

                if (chance <= .08){ // Buyer got four beers, round on him!
                    Double sellPrice = b.price; 
                    sellPrice += b.price * 4;
                }
                
                if (chance <= .02){ // Ok, buyer had a big party today. 6 beers
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
    
    /**
     * Returns the most expensive beer in the given list of beers.
     * 
     * @param bList The list of beers to search.
     * @return The most expensive beer in the list, or null if the list is empty.
     */
    Beer getMostExpensiveBeer(ArrayList<Beer> bList) {
        double highPrice = 0; // Initialize the highest price to zero.
        int selected = -1; // Initialize the selected beer index to -1.
        
        // Iterate through the list of beers.
        for (int index = 0; index < bList.size(); index++) {
            Beer b = bList.get(index); // Get the current beer in the list.
            if (b.price > highPrice) { // If the current beer's price is higher than the current highest price:
                selected = index; // Select the current beer.
                highPrice = b.price; // Set the new highest price.
            }
        }
        
        if (selected == -1) { // If no beer was selected:
            return null; // Return null.
        } else { // Otherwise:
            return bList.get(selected); // Return the selected beer.
        }
    }



    Beer HappyServeBeer(Customer c, ArrayList<Beer> beerInStock){
        // Set initial sale chance to 70%
        double saleChance = .7;
        
        // Adjust sale chance based on customer type
        if(c.type == Enums.CustomerType.WantsOne) saleChance = .9;
        if(c.type == Enums.CustomerType.JustLooking) saleChance = .5;

        // Get a list of all beers in stock that match the customer's preference
        ArrayList<Beer> desiredList = Beer.getBeerByType(beerInStock, c.preference);
        Beer b;

        // Get the most expensive beer from the desired list
        b = getMostExpensiveBeer(desiredList);

        // If no desired beer is available, reduce sale chance and get the most expensive beer overall
        if(b == null){
            saleChance -= .2;
            b = getMostExpensiveBeer(beerInStock);
        }

        // If a desired beer is available, adjust sale price based on chance and other factors
        else{
            double chance = Utility.rnd();
            if (chance <= saleChance){
                if (chance <= .5){ // Buyer got two of this beer
                    Double sellPrice = b.price;
                    sellPrice += b.HappyPrice;
                }

                if (chance <= .3){ // Buyer got four beers, round on him!
                    Double sellPrice = b.price; 
                    sellPrice += b.HappyPrice * 4;
                }
                
                if (chance <= .1){ // Ok, buyer had a big party today. 6 beers
                    Double sellPrice = b.price;
                    sellPrice += b.HappyPrice * 6;
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



}