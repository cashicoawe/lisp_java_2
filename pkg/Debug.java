package pkg;
import java.util.*;
import java.io.*;

public class Debug {
    public static Boolean on = false;
    public static ArrayList<String> flags = new ArrayList<String>();

    public static void p(String flag, String title, String body){
        if(on && flags.contains(flag)){
            System.out.println(title + "[\n" + body + "\n]");
        }
    }
}