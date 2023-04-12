import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

public abstract class Beer {
    String name;
    int cost;
    Double price;
    Double alcVol;
    Enums.BeerType type; 

    // Will need beer in stock later on
    int stock;

    Beer(){

    }

    // utility for getting adjusted cost by beer type
    double getCost(int low, int high){
        int cost = Utility.rndFromRange(low, high);
        /*if (type == Enums.BeerType.IPA) cost = 
        if (type == Enums.BeerType.Lager) cost = 
        if (type == Enums.BeerType.Stout) cost = 
        if (type == Enums.BeerType.Ale) cost = 
        if (type == Enums.BeerType.Sour) cost = 
        if (type == Enums.BeerType.Porter) cost = */
        return cost; 
    }
}

class IPA extends Beer {

    IPA() {
        super();
        type = Enums.BeerType.IPA;
        
    }
}
class Porter extends Beer {

    Porter() {
        super();
        type = Enums.BeerType.IPA;
        
    }
}
class Sour extends Beer {

    Sour() {
        super();
        type = Enums.BeerType.IPA;
        
    }
}
class Stout extends Beer {

    Stout() {
        super();
        type = Enums.BeerType.IPA;
        
    }
}
class Ale extends Beer {

    Ale() {
        super();
        type = Enums.BeerType.IPA;
        
    }
}
class Lager extends Beer {

    Lager() {
        super();
        type = Enums.BeerType.IPA;
        
    }
}
