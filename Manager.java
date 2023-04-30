import java.util.Scanner;
//import java.lang.reflect.Array;
import java.util.ArrayList;
// Command Pattern for Interface

public class Manager implements SysOut{
    void fireEmployee(String employee){

    }


    void hireEmployee (String Name){

    }
}

interface Manager_interface {
    String execute(Brewery Nova);
}
class giveRaise implements Manager_interface, SysOut{
    public String execute (Brewery Nebula){
        String chosenEmployee = "";
        Scanner choice = new Scanner(System.in);
        Boolean input = true;
        String returnStr = "";

        while(input){
            Boolean employeeFound = false;
            out("Here are the employees that are currently working here.");
            for (int i = 0; i < Nebula.employeeList.size(); i++){
                out(Nebula.employeeList.get(i).name);
            }

            out("Please enter the name of the employee you wish to give a raise to.");
            chosenEmployee = choice.nextLine();

            for (int j = 0; j < Nebula.employeeList.size(); j++){
                if (Nebula.employeeList.get(j).name.equalsIgnoreCase(chosenEmployee)){
                    employeeFound = true;
                    Nebula.employeeList.get(j).pay += 5;
                    returnStr = "Employee, " + chosenEmployee + ", has gotten a raise.";
                }
            }
            if(employeeFound){
                input = false;
            }
            else out("This person does not work at Nebula Brewing Co.");
        }
        return returnStr;
    }
}

class fireEmployee implements Manager_interface, SysOut{
    public String execute (Brewery Nebula){
        String inputRemove = "";
        Scanner remove = new Scanner(System.in);
        Boolean input = true;
        String returnStr = "";

        while(input){
            Boolean employeeFound = false;
            out("Here are the employees that are currently working here.");
            for (int i = 0; i < Nebula.employeeList.size(); i++){
                out(Nebula.employeeList.get(i).name);
            }

            out("Please enter the name of the employee you wish to fire.");
            inputRemove = remove.nextLine();

            for (int j = 0; j < Nebula.employeeList.size(); j++){
                if (Nebula.employeeList.get(j).name.equalsIgnoreCase(inputRemove)){
                    employeeFound = true;
                    Nebula.employeeList.remove(j);
                    returnStr = "Employee, " + inputRemove + ", has been fired.";
                }
            }
            if(employeeFound){
                input = false;
            }
            else out("This person does not work at Nebula Brewing Co.");
        }
        return returnStr;
    }
}

class addNewBeer implements Manager_interface, SysOut{
    public String execute(Brewery Nova){
        Boolean input = true;
        //Takes in the name of the beer which is an input made by the manager/user
        Scanner myObj1 = new Scanner (System.in);
        out("What would you like to name your beer?");
        String newBeerName = myObj1.nextLine();
    

        //Need to get the type of beer 
        Scanner myObj2 = new Scanner(System.in);
        while (input){
            Beer n;
            out("Please type in one of the following kinds of beer you would like to add.(IPA, Lager, Stout, Ale, Sour, Porter)");
            String beerInput = myObj2.nextLine();
            switch(beerInput.toLowerCase()){
                case "ipa":
                    input = false;
                    n = new IPA(newBeerName);
                    Nova.beerInStock.add(n);
                    break;

                case "lager":
                    input = false; 
                    n = new Lager(newBeerName);
                    Nova.beerInStock.add(n);
                    break;

                case "stout":
                    input = false; 
                    n = new Stout(newBeerName);
                    Nova.beerInStock.add(n);
                    break;

                case "ale":
                    input = false; 
                    n = new Ale(newBeerName);
                    Nova.beerInStock.add(n);
                    break;

                case "sour":
                    input = false; 
                    n = new Sour(newBeerName);
                    Nova.beerInStock.add(n);
                    break;

                case "porter":
                    input = false; 
                    n = new Porter(newBeerName);
                    Nova.beerInStock.add(n);
                    break;

                default:
                    out("This beer type does not match any of the options. Please enter it again.");
            }
            
        }
        return("Beer " + newBeerName + " has been added! Good Job brewster!");
    }

}


class removeBeer implements Manager_interface, SysOut{
    // public ArrayList<Beer> listBeer = new ArrayList<>();
    // StringBuilder beerInventory = new StringBuilder();
    /*void RemoveBeer(String beer, ArrayList<String> coldBeers) {
        for (int q = 0; q < coldBeers.size(); q++){
            if (coldBeers.get(q) == beer){
                String msgBeer = coldBeers.get(q);
                coldBeers.remove(q);
                out("The beer " + msgBeer + " has been removed!");
            }
        }
    }*/

    public String execute(Brewery Nova){
        /*for(Beer b: Nova.beerInStock){
            listBeer.add(b); // Adds beer from current inventory
            beerInventory.append(b.name + "\n");
        }*/
        String inputRM = "";
        Scanner remove = new Scanner(System.in);
        Boolean input = true;
<<<<<<< HEAD
=======
        String returnStr = "";
>>>>>>> 8e1edc6e9a8bf59246af840519693b08443720bb
        while (input){
            Boolean beerFound = false;
            out("Here are the beers we currently have in inventory!");
            for (int i = 0; i < Nova.beerInStock.size(); i++){
                out(Nova.beerInStock.get(i).name);
            }
            out("Please enter the name of the beer you wish to remove from here.");
            inputRM = remove.nextLine();
            for(int j = 0; j < Nova.beerInStock.size();j++){
<<<<<<< HEAD
                if(Nova.beerInStock.get(j).name == inputRM){
=======
                if(Nova.beerInStock.get(j).name.equalsIgnoreCase(inputRM)){
>>>>>>> 8e1edc6e9a8bf59246af840519693b08443720bb
                    beerFound = true;
                    Nova.beerInStock.remove(j);
                    returnStr = "The beer selected, " + inputRM + ", has been removed from the menu.";
                }
            }
            if (beerFound){
                input = false;
            }
            else out("Beer was not found make sure the beer is in the current inventory.");

        }
        return returnStr;
    }
}

class showInventory implements Manager_interface, SysOut{ // Function will show the beer along with how many of these beers have sold 
    public ArrayList<Beer> beerInventory = new ArrayList<>();
    public ArrayList<String> sBeerInventory = new ArrayList<>();
    StringBuilder Beers = new StringBuilder();
    public String execute(Brewery Nova){
        for (Beer i: Nova.beerInStock){
            Beers.append(i.name + " Beer Sold: " + i.BeersSold + " Beer Stock: " + i.beerStockOunces+ "\n");
        }
        return Beers.toString();
    }
}

class showEmployeeStats implements Manager_interface, SysOut{
    public ArrayList<Employee> employeeList = new ArrayList<>();
    StringBuilder employees = new StringBuilder();
    public String execute(Brewery Nebula){
        for (Employee e : Nebula.employeeList){
            employees.append(e.name + "- Misbehavior Strikes: " + e.strikes + " | Days Worked: " + e.daysWorked + " | Pay Earned: " + e.payEarned);
        }
        return employees.toString();
    }
}

class restockBeer implements Manager_interface, SysOut{ //Needed to restock beer when it is running low
    Scanner restockObj = new Scanner(System.in);
    public String execute(Brewery Nova){
        out("Which beer would you like to stock? (Please enter the name of the beer as it is on the list above.)");
        Boolean restocked = false;
        String returnBeer;
        Boolean loop = true;
        final int ouncesNeeded = 10000; // change to 8000
        int need = 0;
        while(loop){
            String beerToStock = restockObj.nextLine();
            for (int i = 0; i < Nova.beerInStock.size(); i++){
                if (Nova.beerInStock.get(i).name.equalsIgnoreCase(beerToStock)){
                    out("Restocking chosen beer " + Nova.beerInStock.get(i) + "...");
                    //Nova.beerInStock.get(i).beerStockOunces = Nova.beerInStock.get(i).beerStockOunces + 8000;
                    if (Nova.beerInStock.get(i).beerStockOunces != ouncesNeeded)
                    {
                        int beerStockOunces = Nova.beerInStock.get(i).beerStockOunces;
                        need = ouncesNeeded - beerStockOunces;
                        out("Restocking chosen beer: " +Nova.beerInStock.get(i).name + "...");
                        Nova.beerInStock.get(i).beerStockOunces += need;
                    }
                    restocked = true;
                    break;
                }
                else {
                    restocked = false;
                }
            }
            if(restocked){
                break;
            }
            
            else {
                out("Whoops looks like the beer is not on the list! Type in another beer name.");
            }
        }
        if (restocked){
            returnBeer = "Beer has been stocked! Added " +need+ " ounces.";
            
        }
        else {
            returnBeer = "Unable to stock beer.";
        }

        return returnBeer;
    } 
}

/* 
class hireEmployee implements Manager_interface, SysOut{
    public String execute(Brewery Nova){
    }
}
class fireEmployee implements Manager_interface, SysOut{
    public String execute(Brewery Nova){
    }
}
*/

class Menu implements SysOut{
    public void ManagerMenu(Brewery Nova, String ManagerName){
        Boolean input = true;
        Scanner myObj = new Scanner(System.in);
        out("Welcome " + ManagerName + ", here are your options as manager of Nebula Brewing Co.");
        while(input){ //Display menu for different options as manager
            out("Please enter one of the follow options (a,b,c,q) to :");
            out("a: Checkout employees");
            out("b: Check beer and see if we need more of a specific kind.");
            out("c: Check to see if beer is selling and/or create a new beer.");
            out("q: quit");
            String breweryInput = myObj.nextLine();

            switch(breweryInput){
                default:
                    out("You have no selcted a valid choice");
                    ManagerMenu(Nova, ManagerName);
                    break;

                case "q":
                    input = false;
                    myObj.close();
                    break;

                case "a":
                    //Checkout employees and any issues going on with them.
                    Boolean inputA = true;
                    Scanner myInputA = new Scanner(System.in);

                    while(inputA){
                        showEmployeeStats employeeStats = new showEmployeeStats();

                        out("Here are your employees' stats for the day. \n" + employeeStats.execute(Nova) + "\n");
                        out("Enter the number of the option you wish to choose.");
                        out("1: Give employee a raise.");
                        out("2: Fire an employee.");
                        out("3: Quit Employee stats menu");

                        String option = myInputA.nextLine();

                        switch(option){
                            case "1":
                                // Give choice employee a raise
                                giveRaise giveEmployeeRaise = new giveRaise();
                                out("Result: " + giveEmployeeRaise.execute(Nova));
                                inputA = false;
                                break;
                            
                            case "2":
                                // Fire an employee
                                fireEmployee fireEmployee = new fireEmployee();
                                out("Result: " + fireEmployee.execute(Nova));
                                break;
                            
                            case "3":
                                // quit stats menu
                                inputA = false;
                                break;
                            default:
                                out("Invalid input. Try again.");
                                break;
                        }
                    }
                    break;

                case "b":
                    //Checkout beer inventory
                    Boolean inputB = true;
                    Scanner myInputB = new Scanner(System.in);
                    while(inputB){
                        showInventory BeerInventory = new showInventory();

                        out("Here is the name of the beer along with beers sold and the current inventory of each beer. \n" + BeerInventory.execute(Nova) + "\n"); //Shows the beer name, beers sold, and beer in stock
                        out("Enter the number of the option you wish to choose.");
                        out("1: Restock Beer.");
                        out("2: Quit.");
                        String option = myInputB.nextLine();

                        switch(option){
                            case "1":
                                //Gives manager option to restock beer.
                                restockBeer beer = new restockBeer();
                                out("Result:" + beer.execute(Nova));
                                inputB = false;
                                break;

                            case "2":
                                //Will quit the menu and go back 
                                inputB = false;
                                break;

                        }
                    }
                    break;

                case "c":
                    Boolean inputC = true;
                    Scanner myInputC = new Scanner(System.in);
                    while(inputC){
                        out("Enter the number of the option you wish to choose.");
                        out("1: Add a new beer.");
                        out("2: Remove a beer.");
                        out("3: To Quit.");
                        String option = myInputC.nextLine();

                        switch(option){
                            case "1": //Option to add beer
                                addNewBeer add = new addNewBeer();
                                out(add.execute(Nova));
                                break;

                            case "2": //Option to remove beer 
                                removeBeer remove = new removeBeer();
                                out(remove.execute(Nova));
                                break;

                            case "3":
                                inputC = false;
                                break;

                        }
                    }
                    break;
                    
            }

        }
    }
}


