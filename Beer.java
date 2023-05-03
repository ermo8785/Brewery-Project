import java.util.ArrayList;

public abstract class Beer {
    String name;
    Double cost;
    Double price;
    Double HappyPrice;
    Double alcVol;
    int BeersSold;
    Enums.BeerType type; 
    int beerStockOunces;

    // Will need beer in stock later on
    //int stock;
    /* Composite Pattern Use Here */
    public Beer(){

    }

    static ArrayList<Beer> getBeerByType(ArrayList<Beer> beerList, Enums.BeerType type){
        ArrayList<Beer> subclassInstances = new ArrayList<>();
        
        for (Beer b : beerList){
            if(b.type == type) subclassInstances.add(b);
        }
        return subclassInstances;
    }

}

class IPA extends Beer {

    IPA() {
        super();
        name = "Milky Way IPA";
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 7.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 6.00; 
        BeersSold = 0;
        beerStockOunces = 8000;
        
    }
    IPA(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 7.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 6.00; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
}
class Porter extends Beer {

    Porter() {
        super();
        name = "Pluto's Porter";
        type = Enums.BeerType.Porter;
        cost = 4.00;
        price = 8.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 7.1; 
        BeersSold = 0;
        beerStockOunces = 0; // Will cost 400 dollars to make 8000 ounces
    }
    Porter(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.Porter;
        cost = 4.00;
        price = 8.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 7.1; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
}
class Sour extends Beer {

    Sour() {
        super();
        name = "Meteor Sour";
        type = Enums.BeerType.Sour;
        cost = 2.50;
        price = 5.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 4.5; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
    Sour(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.Sour;
        cost = 2.50;
        price = 5.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 4.5; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
}
class Stout extends Beer {

    Stout() {
        super();
        name = "Galactical Stout";
        type = Enums.BeerType.Stout;
        cost = 4.50;
        price = 9.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 9.1; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
    Stout(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.Stout;
        cost = 4.50;
        price = 9.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 9.1; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
}
class Ale extends Beer {
    Ale() {
        super();
        name = "Space Ale-ien";
        type = Enums.BeerType.Ale;
        cost = 4.50;
        price = 7.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 6.0;
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
    Ale(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.Ale;
        cost = 4.50;
        price = 7.00;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 6.0;
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
}
class Lager extends Beer {
    Lager() {
        super();
        name = "Nova Lager";
        type = Enums.BeerType.Lager;
        cost = 2.50;
        price = 6.50;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 6.00; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
    Lager(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.Lager;
        cost = 2.50;
        price = 6.50;
        HappyPrice = 4.00; //Four dollar Beers!
        alcVol = 6.00; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }
}
