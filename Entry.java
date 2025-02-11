import java.util.*;
import java.io.*;

public class Entry {
    public static void main(String[] args){
        Debug.init();
        Syntax.lex_test();
    }
}

class Pair {
    private Object car, cdr;
    public Pair(Object car, Object cdr){
        this.car = car;
        this.cdr = cdr;
    }
    public Object car() {return car;}
    public Object cdr() {return cdr;}
}

class Result {
    public Object body;
    public Object message;
    public Boolean success;
}

class Syntax {
    private static String debugflag = "Syntax";
    public static String lex(String text){
        Debug.p(debugflag, "lex() text", text);
        // String t = text
        // .replaceAll("\\(", " ( ")
        // .replaceAll("\\)", " ) ")
        // .replaceAll("\n", " ")
        // .replaceAll("\t", " ")
        // .replaceAll("\\.", " . ")
        // .trim()
        // .replaceAll(" +", " . ")
        // .replaceAll(" +", " ")
        // .replaceAll("\\.( \\.)+", ".")
        // .replaceAll("\\. \\)", ")")
        // .replaceAll("\\( \\.", "(");

        // String t2;
        // while(true){
        //     t2 = t
        //     .replaceAll("NIL( . NIL)+", "NIL")
        //     .replaceAll(" {2,}", " ")
        //     .replaceAll("\\( NIL \\)", "NIL")
        //     .trim();
        //     Debug.p(debugflag, "lex() loop", t + "\n" + t2);
        //     if(t2.equals(t)) break;
        //     t = t2;
        // }
        // return t;
    }
    public static void lex_test(){
        Debug.flags.add("Syntax");
        Debug.p(debugflag, "lex_test() start");
        Syntax.lex("(hello)");        
        Syntax.lex("(car (x y))");
        Syntax.lex("(car (x . y))");
        Syntax.lex("((lambda (params) expression)(values))");        
        Syntax.lex("((lambda (params)  expression)(values))");
        Syntax.lex("((lambda (params)  expression)(values))");
        Syntax.lex("(()()())");
        Syntax.lex("(....)");
        Syntax.lex("(....");
        Syntax.lex("....");
        Syntax.lex("NIL .");
        Debug.p(debugflag, "lex_test() end");
    }
}

class Debug {
    public static ArrayList<String> flags = new ArrayList<String>();
    public static void init() {
        flags.add("Syntax");
        System.out.println("hello\t" + flags.toString());
    }
    public static void p(String flag, String title, Object body){
        if(flags.contains(flag)){
            System.out.println("\n" + flag + "." + title +"-----------\n" + body + "\n-----------");
        }
    }
    public static void p(String flag, String title){
        if(flags.contains(flag)){
            System.out.println("\n" + flag + "." + title +"--------------------------------------------");
        }
    }
}