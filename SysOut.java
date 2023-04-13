public interface SysOut {
    default void out(String msg){
        System.out.println(msg);
    }
}