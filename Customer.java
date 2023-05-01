import java.util.Arrays;
import java.util.List;

public class Customer {
    String name;
    Enums.CustomerType type;
    Enums.BeerType preference;
    static List<String> names = Arrays.asList("Luke","Leia","Han","Chewy");
    static Namer namer = new Namer(names);
    Customer() {
        preference = Utility.randomEnum(Enums.BeerType.class);
        type = Utility.randomEnum(Enums.CustomerType.class);
        name = namer.getNext();
    }
}
