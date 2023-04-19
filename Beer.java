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

    IPA() {
        super();
        name = "Base Ipa";
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 7.00;
        alcVol = 6.00; 
        BeersSold = 0;
    }
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

    Porter() {
        super();
        name = "Base Porter";
        type = Enums.BeerType.IPA;
        cost = 4.00;
        price = 8.00;
        alcVol = 7.1; 
        BeersSold = 0;
    }
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

    Sour() {
        super();
        name = "Base Sour Beer";
        type = Enums.BeerType.IPA;
        cost = 2.50;
        price = 5.00;
        alcVol = 4.5; 
        BeersSold = 0;
    }
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

    Stout() {
        super();
        name = "Base Stout";
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 9.00;
        alcVol = 9.1; 
        BeersSold = 0;
    }
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
    Ale() {
        super();
        name = "Base Ale";
        type = Enums.BeerType.IPA;
        cost = 4.50;
        price = 7.00;
        alcVol = 6.0;
        BeersSold = 0;
    }
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
    Lager() {
        super();
        name = "Base Lager";
        type = Enums.BeerType.IPA;
        cost = 2.50;
        price = 6.50;
        alcVol = 6.00; 
        BeersSold = 0;
    }
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
