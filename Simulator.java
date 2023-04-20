import java.util.Scanner;
// Simulator to cycle for select number of days
public class Simulator implements SysOut {
    final int numDays;
    Enums.DayOfWeek dayOfWeek;
    Simulator() {
        numDays = 5;  // magic number for days to run here
        dayOfWeek = Utility.randomEnum(Enums.DayOfWeek.class);  // we'll start on a random day (for fun)
    }

    // cycling endlessly through enum values
    // https://stackoverflow.com/questions/34159413/java-get-next-enum-value-or-start-from-first
    public Enums.DayOfWeek getNextDay(Enums.DayOfWeek e)
    {
        int index = e.ordinal();
        int nextIndex = index + 1;
        Enums.DayOfWeek[] days = Enums.DayOfWeek.values();
        nextIndex %= days.length;
        return days[nextIndex];
    }

    void run() {
        Brewery brewery = new Brewery();
        Scanner myObj = new Scanner(System.in);
        out("Welcome new manager! What is your name? ");
        String managerName = myObj.nextLine();
        for (int day = 1; day <= numDays; ++day) {
            out(">>> Start Simulation Day "+day+" "+dayOfWeek);
            if (dayOfWeek == Enums.DayOfWeek.Mon || dayOfWeek == Enums.DayOfWeek.Wed) brewery.happyHourAllDay(dayOfWeek);  // race days wed and sun
            else brewery.normalDay(dayOfWeek);  // normal stuff on other days
            out(">>> End Simulation Day "+day+" "+dayOfWeek+"\n");
            Menu menu = new Menu();
            menu.ManagerMenu(brewery, managerName);
            dayOfWeek = getNextDay(dayOfWeek);  // increment to the next day
        }
        myObj.close();
    }
}