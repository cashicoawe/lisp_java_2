import java.util.*;
import java.io.*;
import pkg.*;

public class Entry{
    public static void main(String[] args){
        try {
            Debug.on = true;
            Debug.flags.add("pipe");
            Debug.flags.add("input");
            Debug.flags.add("isVailedList");
            Debug.flags.add("ss");
            Debug.flags.add("toSexpression");
            Debug.flags.add("format");
            // Debug.p("hello", "title", "body");
            Scanner sc = new Scanner(System.in);
            if(System.in.available() != 0){
                Debug.p("pipe", "pipe", "true");
            } else {
                Debug.p("pipe", "pipe", "false");
                while(true){
                    System.out.println("input>>");
                    String t = sc.nextLine();
                    Debug.p("input", "input", t);
                    if(t == "") break;

                    String ft = Lisp.format(t);
                    Debug.p("isVailedList", "format", ft);
                    // Debug.p("isVailedList", "isVailedList", Lisp.isVailedList(ft).toString());
                    // if(!Lisp.isVailedList(ft)) continue;

                    // Debug.p("toSexpression", "toSexpression", Lisp.toSexpression(ft).toString());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}