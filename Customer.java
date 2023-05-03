import java.util.Arrays;
import java.util.List;

public class Customer {
    String name;
    Enums.CustomerType type;
    Enums.BeerType preference;
    static List<String> names = Arrays.asList("Luke","Leia","Han","Chewy", "Kenny", "Marlene", "Sharon", "Josh", "Sebastian", "Cornelius", "Maggie", "Gen");
    static Namer namer = new Namer(names);
    Customer() {
        preference = Utility.randomEnum(Enums.BeerType.class);
        type = Utility.randomEnum(Enums.CustomerType.class);
        name = namer.getNext();
    }
}
