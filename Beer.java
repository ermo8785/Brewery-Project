public abstract class Beer {
    String name;
    Double cost;
    Double price;
    Double alcVol;
    int BeersSold;
    Enums.BeerType type; 

    // Will need beer in stock later on
    int stock;

    public Beer(){

    }

}

class IPA extends Beer {

    IPA(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 7.00;
        alcVol = 6.00; 
        BeersSold = 0;
    }
}
class Porter extends Beer {

    Porter(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 4.00;
        price = 8.00;
        alcVol = 7.1; 
        BeersSold = 0;
    }
}
class Sour extends Beer {

    Sour(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 2.50;
        price = 5.00;
        alcVol = 4.5; 
        BeersSold = 0;
    }
}
class Stout extends Beer {

    Stout(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 9.00;
        alcVol = 9.1; 
        BeersSold = 0;
    }
}
class Ale extends Beer {

    Ale(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 7.00;
        alcVol = 6.0;
        BeersSold = 0;
    }
}
class Lager extends Beer {

    Lager(String beerName) {
        super();
        name = beerName;
        type = Enums.BeerType.IPA;
        cost = 2.50;
        price = 6.50;
        alcVol = 6.00; 
        BeersSold = 0;
    }
}
