import java.util.Scanner;
//import java.lang.reflect.Array;
import java.util.ArrayList;
// Command Pattern for Interface

public class Manager implements SysOut{
    void FireEmployee(String employee){

    }


    void hireEmployee (String Name){

    }
}

interface Manager_interface {
    String execute(Brewery Nova);
}

class addNewBeer implements Manager_interface, SysOut{
    void newBeer(String beerName, String b){ //Helper function to create a new beer 
        if (b == Enums.BeerType.IPA.toString()){
            Beer n = new IPA(beerName);
            out("You have created " + n.name);
        } 
        else if (b == Enums.BeerType.Ale.toString()) {
             Beer n = new Ale(beerName);
             out("You have created " + n.name);
        }
        else if (b == Enums.BeerType.Sour.toString()) {
            Beer n = new Sour(beerName);
            out("You have created " + n.name);
        }
        else if (b == Enums.BeerType.Stout.toString()){
             Beer n = new Stout(beerName);
             out("You have created " + n.name);
        }
        else if (b == Enums.BeerType.Porter.toString()) {
            Beer n = new Porter(beerName);
            out("You have created " + n.name);
        }
        else if (b == Enums.BeerType.Lager.toString()) {
            Beer n = new Lager(beerName);
            out("You have created " + n.name);
        }
    } 

    public String execute(Brewery Nova){
        Boolean input = true;
        //Takes in the name of the beer which is an input made by the manager/user
        Scanner myObj1 = new Scanner (System.in);
        out("What would you like to name your beer?");
        String newBeerName = myObj1.nextLine();
    

        //Need to get the type of beer 
        Scanner myObj2 = new Scanner(System.in);
        while (input){
            out("Please type in one of the following kinds of beer you would like to add.(IPA, Lager, Stout, Ale, Sour, Porter)");
            String beerInput = myObj2.nextLine();
            switch(beerInput.toLowerCase()){
                case "ipa":
                    newBeer(newBeerName,beerInput);
                    input = false;
                    break;

                case "lager":
                    newBeer(newBeerName,beerInput);
                    input = false; 
                    break;

                case "stout":
                    newBeer(newBeerName,beerInput);
                    input = false; 
                    break;

                case "ale":
                    newBeer(newBeerName,beerInput);
                    input = false; 
                    break;

                case "sour":
                    newBeer(newBeerName,beerInput);
                    input = false; 
                    break;

                case "porter":
                    newBeer(newBeerName,beerInput);
                    input = false; 
                    break;

                default:
                    out("This beer type does not match any of the options. Please enter it again.");
            }
            
        }
        return(newBeerName);
    }

}

    

class removeBeer implements Manager_interface, SysOut{
    public ArrayList<Beer> listBeer = new ArrayList<>();
    StringBuilder beerInventory = new StringBuilder();
    void RemoveBeer(String beer, ArrayList<String> coldBeers) {
        for (int q = 0; q < coldBeers.size(); q++){
            if (coldBeers.get(q) == beer){
                String msgBeer = coldBeers.get(q);
                coldBeers.remove(q);
                out("The beer " + msgBeer + " has been removed!");
            }
        }
    }

    public String execute(Brewery Nova){
        for(Beer b: Nova.beerInStock){
            listBeer.add(b); // Adds beer from current inventory
            beerInventory.append(b.name + "\n");
        }
        Scanner remove = new Scanner(System.in);
        Boolean input = false;
        while (input){
            Boolean beerFound = false;
            out("Here are the beers we currently have in inventory!");
            for (int i = 0; i < listBeer.size(); i++){
                out(listBeer.get(i).name);
            }
            out("Please enter the name of the beer you wish to remove from here.");
            String inputRM = remove.nextLine();
            for(int j = 0; j < listBeer.size();j++){
                if(listBeer.get(j).toString() == inputRM){
                    beerFound = true;
                    Nova.beerInStock.remove(j);
                }
            }
            if (beerFound){
                input = false;
            }
            else out("Beer was not found make sure the beer is in the current inventory.");

        }
        return inputRM;
    }
}

class showInventory implements Manager_interface, SysOut{ // Function will show the beer along with how many of these beers have sold 
    public ArrayList<Beer> beerInventory = new ArrayList<>();
    public ArrayList<String> sBeerInventory = new ArrayList<>();
    StringBuilder Beers = new StringBuilder();
    public String execute(Brewery Nova){
        for (Beer i: Nova.beerInStock){
            Beers.append(i.name + " Beer Sold: " + i.BeersSold + " Beer Stock: " + i.stock+ "\n");
        }
        return Beers.toString();
    }

}

class restockBeer implements Manager_interface, SysOut{ //Needed to restock beer when it is running low
    Scanner restockObj = new Scanner(System.in);
    public String execute(Brewery Nova){
        out("Which beer would you like to stock? (Please enter the name of the beer as it is on the list above.)");
        Boolean restocked = true;
        String returnBeer;
        Boolean loop = true;
        while(loop){
            String beerToStock = restockObj.nextLine();
            for (Beer j: Nova.beerInStock){
                if (j.name == beerToStock){
                    j.stock = j.stock + 200;
                }
                else {
                    restocked = false;
                }
            }
            if(restocked == true){
                loop = false;
            }
            else {
                out("Whoops looks like the beer is not on the list! Type in another beer name.");
            }
        }
        if (restocked){
            loop = false;
            returnBeer = "Beer has been stocked!";
        }
        else {
            returnBeer = "Unable to sock beer.";
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
                    //Checkout empoyees and any issues going on with them.
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
                                out("The beer " + add.execute(Nova) + " has been added!");
                                break;

                            case "2": //Option to remove beer 
                                removeBeer remove = new removeBeer();
                                out("You have removed " + remove.execute(Nova) + "from inventory!");
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


