import java.util.ArrayList;
import java.util.Arrays;

public class Entry {
    public static void main(String[] args) {
        Debug.init();
        Syntax.tree_tests();
        return;
    }
}

class Pair {
    private Object car;
    private Object cdr;

    Pair(Object car, Object cdr){
        this.car = car;
        this.cdr = cdr;
    }

    public Object car(){
        return this.car;
    }
    public Object cdr(){
        return this.cdr;
    }
}

class Result {
    public Object body;
    public Boolean success;
    public Object message;
    Result(Object body, Boolean success, Object message)
    {
        this.body = body;
        this.success = success;
        this.message = message;
    }

    Result(Object body){
        this.body = body;
        this.success = true;
        this.message = "";
    }
}

class Debug {
    public static ArrayList<String> flags = new ArrayList<String>();
    public static void init(){
        flags.add("hello");
        flags.add("Syntax");
    }
    public static void p(String flag, String title, Object body)
    {
        if(flags.contains(flag)){
            System.out.println("-----------------" + flag + "." + title + "\n" + body + "\n-----------------");
        }
    }
}

class Syntax {
    static final String debugflag = "Syntax";
    public static Result tree(ArrayList<String> s, int start, int end){
        // Debug.p(debugflag, "tree", "hello");
        Debug.p(debugflag, "tree", s.subList(start, end));
        if(s.size() - 1 > start){
            tree(s, start + 1, end);
        }
        return null;
    }
    public static void tree_test(String s){
        Debug.p(debugflag, "tree_test()----------------", s);
        ArrayList<String> ss = new ArrayList<String>(Arrays.asList(s.split(" ")));
        tree(ss, 0, ss.size());
    }
    public static void tree_tests(){
        tree_test("hello");
        tree_test("a b c");
        tree_test("a ( b c )");
    }
    // public static int findEdge(ArrayList<String> s, int i){
    //     if(s.get(i).equals("(")){

    //     }
    // }
}