//import java.util.ArrayList;
import java.util.Scanner;

// Command Pattern for Interface

public class Manager implements SysOut{
    void FireEmployee(String employee){

    }

    void RemoveBeer(String beer) {

    }

    void hireEmployee (String Name){

    }
}

interface Manager_interface {
    String execute(Brewery Nova);
}

class addNewBeer implements Manager_interface, SysOut{
    void newBeer(String beerName, String b){ //Helper function to create a new beer 
        Beer n = null;
        if (b == Enums.BeerType.IPA.toString()) n = new IPA(beerName);
        if (b == Enums.BeerType.Ale.toString()) n = new Ale(beerName);
        if (b == Enums.BeerType.Sour.toString()) n = new Sour(beerName);
        if (b == Enums.BeerType.Stout.toString()) n = new Stout(beerName);
        if (b == Enums.BeerType.Porter.toString()) n = new Porter(beerName);
        if (b == Enums.BeerType.Lager.toString()) n = new Lager(beerName);
        out("You have created " + n.name);
    } 

    public String execute(Brewery Nova){
        Boolean input = true;
        //Takes in the name of the beer which is an input made by the manager/user
        Scanner myObj1 = new Scanner (System.in);
        out ("What would you like to name your beer?");
        String newBeerName = myObj1.nextLine();
        myObj1.close();

        //Need to get the type of beer 
        Scanner myObj2 = new Scanner(System.in);
        while (input){
            out("Please type in one of the following kinds of beer you would like to add.(IPA, Lager, Stout, Ale, Sour, Porter)");
            String beerInput = myObj2.nextLine();
            if (beerInput.toLowerCase() == "ipa" || beerInput.toLowerCase() == "lager" || beerInput.toLowerCase() == "stout" || beerInput.toLowerCase() == "ale" || beerInput.toLowerCase() == "sour" || beerInput.toLowerCase() == "porter"){
                newBeer(newBeerName,beerInput);
                input = false;
            }
        }
        myObj2.close();

        return(newBeerName);
    }

}

    
class fireEmployee implements Manager_interface, SysOut{
        public String execute(Brewery Nova){

        }
}

class removeBeer implements Manager_interface, SysOut{
    public String execute(Brewery Nova){

    }
}

class hireEmployee implements Manager_interface, SysOut{
    public String execute(Brewery Nova){

    }
}


class Menu implements SysOut{
    public void ManagerMenu(Brewery Nova, String ManagerName){
        Boolean input = true;
        Scanner myObj = new Scanner(System.in);
        out("Welcome " + ManagerName + "here are your options as manager of Nova brewery");

        while(input){ //Display menu for different options as manager
            out("Please enter one of the follow options (a,b,c,q) to :");
            out("a: Checkout employees");
            out("b: Check beer and see if we need more of a specific kind.");
            out("c: Check to see if beer is selling and/or create a new beer.");
            out("q: quit");
            String breweryInput = myObj.nextLine();

            switch(breweryInput){
                case "q":
                    input = false;
                    break;

                case "a":
                    //Checkout empoyees and any issues going on with them.
                    break;

                case "b":
                    //Checkout beer inventory
                    break;

                case "c":
                    //Give option to add a beer
                    addNewBeer add = new addNewBeer();
                    out("You have successfully created new brew " + add + ".");
                    break;


            }

        }


    }
}

 