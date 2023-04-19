import java.util.ArrayList;
public class BeerFactory {
    ArrayList<Beer> beer;

    BeerFactory(ArrayList<Beer> stock){
        beer = stock;
    }
    public newBeer addMoreBeer(String beerType){
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
        return null;
    }
}

interface newBeer{
    void importBeer();
}

abstract class newBeerType implements newBeer{
    ArrayList<Beer> beer;
    newBeerType(ArrayList<Beer> beerInStock){
        beer = beerInStock;
    }
}

class newIpa extends newBeerType{
    newIpa(ArrayList<Beer> beerInStock){
        super(beerInStock);
    }

    @Override
    public void importBeer(){
        for(int i = 0; i < 2; i++){
            Beer newBeer = new IPA();
            beer.add(newBeer);
        }
    }
}
class newSour extends newBeerType{
    newSour(ArrayList<Beer> beerInStock){
        super(beerInStock);
    }

    @Override
    public void importBeer(){
        for(int i = 0; i < 2; i++){
            Beer newBeer = new Sour();
            beer.add(newBeer);
        }
    }
}
class newPorter extends newBeerType{
    newPorter(ArrayList<Beer> beerInStock){
        super(beerInStock);
    }

    @Override
    public void importBeer(){
        for(int i = 0; i < 2; i++){
            Beer newBeer = new Porter();
            beer.add(newBeer);
        }
    }
}
class newStout extends newBeerType{
    newStout(ArrayList<Beer> beerInStock){
        super(beerInStock);
    }

    @Override
    public void importBeer(){
        for(int i = 0; i < 2; i++){
            Beer newBeer = new Stout();
            beer.add(newBeer);
        }
    }
}
class newLager extends newBeerType{
    newLager(ArrayList<Beer> beerInStock){
        super(beerInStock);
    }

    @Override
    public void importBeer(){
        for(int i = 0; i < 2; i++){
            Beer newBeer = new Lager();
            beer.add(newBeer);
        }
    }
}
class newAle extends newBeerType{
    newAle(ArrayList<Beer> beerInStock){
        super(beerInStock);
    }

    @Override
    public void importBeer(){
        for(int i = 0; i < 2; i++){
            Beer newBeer = new Ale();
            beer.add(newBeer);
        }
    }
}