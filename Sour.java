public class Sour implements BeerInterface{
    String name;
    Double cost;
    Double price;
    Double alcVol;
    int BeersSold;
    Enums.BeerType type; 
    int beerStockOunces;

    Sour(){
        super();
        name = "Base Sour";
        type = Enums.BeerType.Sour;
        cost = 4.50;
        price = 7.00;
        alcVol = 6.00; 
        BeersSold = 0;
        beerStockOunces = 8000;
    }

    Sour(String beerName){
        super();
        name = beerName;
        type = Enums.BeerType.Sour;
        cost = 4.50;
        price = 7.00;
        alcVol = 6.00; 
        BeersSold = 0;
        beerStockOunces = 8000; // Will cost 400 dollars to make 8000 ounces
    }

    @Override 
    public String getBeerName(){
        return name;
    }

    @Override
    public Enums.BeerType getBeerType(){
        return type;
    }

    @Override
    public Double getPrice(){
        return price;
    }

    @Override
    public Double getAlcoholVolume(){
        return alcVol;
    }

    @Override
    public int getBeersSold(){
        return BeersSold;
    }

    @Override
    public int getBeerStockOunces(){
        return beerStockOunces;
    }
}
