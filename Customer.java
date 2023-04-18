import java.util.Arrays;
import java.util.List;

public class Customer {
    String name;
    Enums.CustomerType preference;
    static List<String> names = Arrays.asList("Luke","Leia","Han","Chewy");
    static Namer namer = new Namer(names);
    Customer() {
        //preference = Utility.randomEnum(Enums.VehicleType.class);
        //type = Utility.randomEnum(Enums.BuyerType.class);
        preference = Utility.randomEnum(Enums.CustomerType.class);
        name = namer.getNext();
    }
}
