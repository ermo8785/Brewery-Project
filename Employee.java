// Importing necessary Java libraries
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;import java.util.concurrent.ThreadLocalRandom;

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

    // https://www.geeksforgeeks.org/how-do-i-generate-random-integers-within-a-specific-range-in-java/
    // Below is a function to generate a random integer within a range 
    public static int getRandomValue(int Min, int Max){
  
        // Get and return the random integer
        // within Min and Max
        return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }

    public static boolean checkForIndex(ArrayList<Integer>idxs, int index){
        boolean val = false;
        for (int i = 0; i < idxs.size(); i++){
            if (index == idxs.get(i)){
                val = true;
            }
        }
        return val;
        
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
            boolean random = true;
            boolean check;
            int count = 0;
            ArrayList <Integer> Idx = new ArrayList<>();
            while (random){
                boolean Clear = true;
                int beer = getRandomValue(0, beerInStock.size()-1);
                Idx.add(beer);
                // For loop will check to see if the index has already been checked for the type of beer
                check = checkForIndex(Idx, beer);
                while (Clear){
                    if (!check){
                        beer = getRandomValue(0, beerInStock.size()-1);
                        check = checkForIndex(Idx, beer);
                    }
                    else if (check){
                        Clear = false;
                    }
                }
                // The next couple of lines check to see if the beer is of the type the customer wants
                Beer beerName = beerInStock.get(beer);
                if (beerName.type == c.preference){
                    beerName.BeersSold += 1;
                    beerName.beerStockOunces -= 8;
                    out("Customer "+c.name+" bought a "+ beerName.name + " from bartender " +name);
                    random = false;
                }
                else if (count > beerInStock.size()){
                    out ("BEER WAS NOT FOUND TO CHANGE STUFF");
                    random = false;
                }

                count ++;
            }

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