import java.util.ArrayList;
public class BeerFactory {
    ArrayList<Beer> beer;

    BeerFactory(ArrayList<Beer> stock){
        beer = stock;
    }
    /*public moreBeer addMoreBeer(String beerType){
        if (beerType == null){
            return null;
        }
        if (beerType.equalsIgnoreCase("IPA")){
            return new newIpa(beer);
        }
        else if(beerType.equalsIgnoreCase("Porter")){
            return new newPorter(beer);
        }
        else if(beerType.equalsIgnoreCase("Stout")){
            return new newStout(beer);
        }
        else if(beerType.equalsIgnoreCase("Sour")){
            return new newSour(beer);
        }
        else if(beerType.equalsIgnoreCase("Lager")){
            return new newLager(beer);
        }
        else if(beerType.equalsIgnoreCase("Ale")){
            return new newAle(beer);
        }
    }*/
}

interface moreBeer{
    void importBeer();
}

abstract class newBeerType implements moreBeer{
    ArrayList<Beer> beer;
    newBeerType(ArrayList<Beer> beerInStock){
        beer = beerInStock;
    }
}


