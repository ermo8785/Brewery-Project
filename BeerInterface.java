/* Composite pattern implementation */
public interface BeerInterface {
    String getBeerName();
    Enums.BeerType getBeerType();
    Double getPrice();
    Double getAlcoholVolume();
    int getBeersSold(); 
    int getBeerStockOunces();
}
