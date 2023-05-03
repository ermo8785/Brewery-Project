
public interface SysOut {

    public static final String ANSI_RESET = "\u001B[0m";
  
    // Declaring the color
    // Custom declaration

    //Text to Yellow in terminal 
    public static final String ANSI_YELLOW = "\u001B[33m";

    //Text to red in terminal 
    public static final String ANSI_RED = "\u001B[31m";
  
    //Text to green in terminal 
    public static final String ANSI_GREEN = "\u001B[32m";

    //Text to Cyan 
    public static final String ANSI_CYAN = "\u001B[36m";

    //Text to Blue 
    public static final String ANSI_BLUE = "\u001B[34m";

    // Main driver method
    default void out(String msg){
        System.out.println(ANSI_YELLOW
                          + msg
                          + ANSI_RESET);
    }

    default void outRed(String msg){
        System.out.println(ANSI_RED 
                            + msg
                            +ANSI_RESET);
    }

    default void outGreen(String msg){
        System.out.println(ANSI_GREEN 
                            + msg
                            +ANSI_RESET);
    }

    default void outCyan(String msg){
        System.out.println(ANSI_CYAN 
        + msg
        +ANSI_RESET);    
    }

    default void outBlue (String msg){
        System.out.println(ANSI_BLUE 
        + msg
        +ANSI_RESET);   
    }

}