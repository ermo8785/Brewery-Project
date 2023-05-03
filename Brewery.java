import java.util.ArrayList;

public class Brewery implements SysOut {
    ArrayList<Employee> employeeList; // a list of all employees currently employed
    ArrayList<Employee> departedEmployees; // a list of all employees who have quit or been fired
    ArrayList<Beer> beerInStock; // a list of all beers currently in stock
    ArrayList<Beer> soldBeer; // a list of all beers sold

    public double budget; // the brewery's current budget
    String textOut = " ";
    Enums.DayOfWeek simDay; // the day of the week in the simulation
    
    Brewery(){
        employeeList = new ArrayList<>();
        departedEmployees = new ArrayList<>();
        beerInStock = new ArrayList<>();
        soldBeer = new ArrayList<>();

        budget = 100000; // set initial budget to $100,000

        BeerFactory beerFactory = new BeerFactory(beerInStock); // create a beer factory object
        beerFactory.addMoreBeer("IPA").importBeer(); // import 6 different types of beer into the beerInStock list
        beerFactory.addMoreBeer("Porter").importBeer();
        beerFactory.addMoreBeer("Stout").importBeer();
        beerFactory.addMoreBeer("Lager").importBeer();
        beerFactory.addMoreBeer("Sour").importBeer();
        beerFactory.addMoreBeer("Ale").importBeer();

        Employee newEmployee = new Bartender(); // create a new bartender object
        employeeList.add(newEmployee); // add three copies of the same new bartender object to the employeeList
        newEmployee = new Bartender(); 
        employeeList.add(newEmployee);
        newEmployee = new Bartender(); 
        employeeList.add(newEmployee);

    }
    // A method to get the current budget of the brewery
    double getBudget(){
        return budget;
    }

    // A method to add money to the brewery's budget
    void moneyIn(double income){
        budget += income;
    }

    // A method to subtract money from the brewery's budget and handle budget overruns
    void moneyOut(double cash){
        budget -= cash;
        if(budget < 0){
            budget += 250000;
            out("*** Budget overrun *** Added $250K, current budget: " + Utility.asDollar(budget));
        }
    }

    // A method to generate a list of customers for the day based on the day of the week
    ArrayList<Customer> getCustomers(Enums.DayOfWeek day){
        int cusMin = 0;
        int cusMax = 20;

        // Determine the minimum and maximum number of customers based on the day of the week
        if (day == Enums.DayOfWeek.Mon || day == Enums.DayOfWeek.Wed){
            cusMin = 10; 
            cusMax= 50;
        }

        // Create a list of customers with a random number of customers within the determined range
        ArrayList<Customer> customers = new ArrayList<Customer>();
        int customerCount = Utility.rndFromRange(cusMin, cusMax);
        for (int i=1; i<=customerCount; ++i) customers.add(new Customer());
        out("Nebula Brewing Co. has "+customerCount+" buyers today...");

        return customers;
    }

    // A method to hire the required number of employees for the brewery
    void hireEmployees(){
        final int employeeNum = 2;

        // Loop through all the types of employees and hire enough employees to reach the required number
        for (Enums.EmployeeType t : Enums.EmployeeType.values()){
            int typeInList = Employee.howManyByType(employeeList, t);
            int need = employeeNum - typeInList;

            for (int i = 0; i <= need; i++){
                addEmployee(t);
            }
        }
    }

    // A method to add a new employee to the employee list
    void addEmployee(Enums.EmployeeType t){
        Employee newBartender = null;
        if (t == Enums.EmployeeType.Bartender) newBartender = new Bartender();

        // Add the new employee to the employee list and output a message indicating the employee has been hired
        out("Hired a new " + newBartender.type + " named " + newBartender.name);
        employeeList.add(newBartender);
    }

    // A method to pay all the employees and track their pay and work days
    void payEmployees(){
        for (Employee e : employeeList){
            moneyOut(e.pay);
            e.daysWorked++;
            e.payEarned += e.pay;
        }
    }

    void checkForQuitters(){
        // get all employees with the type of "Bartender"
        ArrayList <Employee> bartender = Employee.getEmployeesByType(employeeList, Enums.EmployeeType.Bartender);
        // generate a random number between 0 and 1
        double bartenderQuit = Math.random(); 
    
        // if the random number is less than or equal to 0.05 (5% chance), a bartender quits
        if(bartenderQuit <= 0.05){
            // select a random bartender who quits
            int randomIndex = Utility.rndFromRange(0, 2);
            Bartender bartenderName = (Bartender) bartender.get(randomIndex);
            // add the bartender to the list of departed employees
            departedEmployees.add(bartenderName);
    
            // remove the bartender from the list of current employees
            for (int i = 0; i < employeeList.size(); i++){
                if (employeeList.get(i) == bartenderName){
                    employeeList.remove(i);
                }
            }
            // print a message that the bartender has quit
            out("Bartender " + bartenderName.name + " has quit Nebula Brewing Co.");
        }
    }
    
    void checkForMisbehavior(Enums.DayOfWeek day){
        // get all employees with the type of "Bartender"
        ArrayList <Employee> bartender = Employee.getEmployeesByType(employeeList, Enums.EmployeeType.Bartender);
        // generate a random number between 0 and 1
        double bartenderMisbehaved = Math.random();
    
        // if it's Monday or Wednesday, there's a higher chance of an employee misbehaving during happy hour
        if (day == Enums.DayOfWeek.Mon || day == Enums.DayOfWeek.Wed){
            // if the random number is less than or equal to 0.60 (60% chance), a bartender misbehaves
            if (bartenderMisbehaved <= 0.60){
                // select a random bartender who misbehaves
                int randomIndex = Utility.rndFromRange(0,2);
                Bartender misbehavingBartender = (Bartender) bartender.get(randomIndex);
                // add the bartender to the list of departed employees
                departedEmployees.add(misbehavingBartender);
    
                // give the bartender a strike
                for (int i = 0; i < employeeList.size(); i++){
                    if (employeeList.get(i) == misbehavingBartender){
                        employeeList.get(i).strikes++;
                    }
                }
            }
        }
        // for any other day of the week
        else{
            // if the random number is less than or equal to 0.35 (35% chance), a bartender misbehaves
            if (bartenderMisbehaved <= 0.35){
                // select a random bartender who misbehaves
                int randomIndex = Utility.rndFromRange(0,2);
                Bartender misbehavingBartender = (Bartender) bartender.get(randomIndex);
                // add the bartender to the list of departed employees
                departedEmployees.add(misbehavingBartender);
    
                // give the bartender a strike
                for (int i = 0; i < employeeList.size(); i++){
                    if (employeeList.get(i) == misbehavingBartender){
                        employeeList.get(i).strikes++;
                    }
                }
            }
        }
    }

    void happyHourAllDay(Enums.DayOfWeek day){
        out("Nice! Happy Hour All Day! There are more customers buying beer today and a chance of greater sells!");

        // Hire employees
        hireEmployees();
        
        // Print message about bartenders serving customers
        out("The bartenders are serving customers...");
            
        // Get the list of customers for the day
        ArrayList<Customer> customers = getCustomers(day);
    
        // Get the list of bartenders
        ArrayList<Employee> bartenders =  Employee.getEmployeesByType(employeeList, Enums.EmployeeType.Bartender);
    
        // Loop through the customers and serve them beer
        for (Customer c : customers){
            out("Customer "+c.name+" wants a "+c.preference);
    
            // Select a random bartender
            int randomBartender = Utility.rndFromRange(0, bartenders.size()-1);
            Bartender bartender = (Bartender) bartenders.get(randomBartender);
    
            // Serve the customer a beer
            Beer beerSold = bartender.HappyServeBeer(c, beerInStock);
    
            // If the beer is not null (i.e. the bartender has the beer in stock)
            if(beerSold != null){
                // Add the beer to the list of sold beers
                soldBeer.add(beerSold);
    
                // Add the price of the beer to the money earned
                moneyIn(beerSold.price);
    
                // Remove the beer from the stock
                beerInStock.removeIf(n -> n.name == beerSold.name);
    
                // Add the beer back to the stock
                beerInStock.add(beerSold);
    
                // Add the cost of the beer to the money spent
                moneyOut(beerSold.cost);
            }
        }
    
        // Check if any employee has misbehaved
        checkForMisbehavior(day);
    
        // Check if any employee has quit
        checkForQuitters();
    
        // Pay employees
        payEmployees();
        reportOut(day);
    }
    

    void normalDay(Enums.DayOfWeek day){
        // Print opening message
        out("Nebula Brewing Co. is opening...");

        //Set the beers in the right array of each type 
        ArrayList <Beer> IPAlist;
        ArrayList <Beer> Porterlist;
        ArrayList <Beer> Stoutlist;
        ArrayList <Beer> Lagerlist;
        ArrayList <Beer> Sourlist;
        ArrayList <Beer> Alelist;

        IPAlist = new ArrayList<>();
        Porterlist = new ArrayList<>();
        Stoutlist = new ArrayList<>();
        Lagerlist = new ArrayList<>();
        Sourlist = new ArrayList<>();
        Alelist = new ArrayList<>();

        for (int i = 0; i < beerInStock.size(); i ++){
            Beer name = beerInStock.get(i);
            if (name.type == Enums.BeerType.IPA){
                IPAlist.add(name);
            }

            if (name.type == Enums.BeerType.Stout){
                Stoutlist.add(name);
            }

            if (name.type == Enums.BeerType.Sour){
                Sourlist.add(name);
            }

            if (name.type == Enums.BeerType.Porter){
                Porterlist.add(name);
            }

            if (name.type == Enums.BeerType.Lager){
                Lagerlist.add(name);
            }

            if (name.type == Enums.BeerType.IPA){
                IPAlist.add(name);
            }
        }
    
        // Hire employees
        hireEmployees();
        
        // Print message about bartenders serving customers
        out("The bartenders are serving customers...");
            
        // Get the list of customers for the day
        ArrayList<Customer> customers = getCustomers(day);
    
        // Get the list of bartenders
        ArrayList<Employee> bartenders =  Employee.getEmployeesByType(employeeList, Enums.EmployeeType.Bartender);
    
        // Loop through the customers and serve them beer
        for (Customer c : customers){
            out("Customer "+c.name+" wants a "+c.preference);
    
            // Select a random bartender
            int randomBartender = Utility.rndFromRange(0, bartenders.size()-1);
            Bartender bartender = (Bartender) bartenders.get(randomBartender);
    
            // Serve the customer a beer
            Beer beerSold = bartender.serveBeer(c, beerInStock, IPAlist, Porterlist,Stoutlist,Sourlist,Alelist,Lagerlist);
    
            // If the beer is not null (i.e. the bartender has the beer in stock)
            if(beerSold != null){
                // Add the beer to the list of sold beers
                soldBeer.add(beerSold);
    
                // Add the price of the beer to the money earned
                moneyIn(beerSold.price);
    
                // Remove the beer from the stock
                beerInStock.removeIf(n -> n.name == beerSold.name);
    
                // Add the beer back to the stock
                beerInStock.add(beerSold);
    
                // Add the cost of the beer to the money spent
                moneyOut(beerSold.cost);
            }
        }
    
        // Check if any employee has misbehaved
        checkForMisbehavior(day);
    
        // Check if any employee has quit
        checkForQuitters();
    
        // Pay employees
        payEmployees();
        
        reportOut(day);
    }
    void reportOut(Enums.DayOfWeek day){
        out("Number of types of beers in stock: "+beerInStock.size());
        textOut = textOut.concat("Number of types of beers in stock: "+beerInStock.size()+" \n");
        out("Beers sold today: " +soldBeer.size());
        textOut = textOut.concat("Beers sold today: " +soldBeer.size()+ " \n");
        out("Current number of employees: "+employeeList.size());
        textOut = textOut.concat("Current number of employees: "+employeeList.size()+" \n");
        out("Current number of employees who quit or have been fired: " + departedEmployees.size());
        textOut = textOut.concat("Current number of employees who quit or have been fired: " + departedEmployees.size()+ " \n");
        out("Current budget: "+Utility.asDollar(getBudget()));
        textOut = textOut.concat("Current budget: "+Utility.asDollar(getBudget())+ " \n");

        writeToFile(day);
    }
    void writeToFile(Enums.DayOfWeek day){
        Logger outFile = new Logger(day);
        outFile.writeLog(textOut);
    }

}