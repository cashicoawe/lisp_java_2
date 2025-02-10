package pkg;
import java.util.*;
import java.io.*;

public class Lisp {
    public static String format(String s){
        String ss;
        // convert to one line
        ss = s
        .replaceAll("\n", " ")
        .replaceAll("\t", " ")
        .replaceAll("\\(", " ( ")
        .replaceAll("\\)", " ) ")
        .replaceAll(" {2,}", " ")
        .trim();

        // convert ( ) to NIL
        ss = ss
        .replaceAll("\\( \\)", " NIL ")
        .replaceAll(" {2,}", " ");

        // add NIL to end of list
        ss = ss.replaceAll("\\)", "NIL )");
        Debug.p("format", "replaceAll(\"\\)\")", ss);

        // // triming NIL
        // ss = ss.replaceAll("( NIL){2,}", " NIL");
        String sst;
        while(true){
            sst = ss
            .replaceAll("( NIL){2,}", " NIL")
            .replaceAll("\\( NIL \\)", " NIL ")
            .replaceAll(" {2,}", " ")
            .trim();

            if(ss.equals(sst)){
                break;
            }else{
                ss = sst;
                Debug.p("format", "trim", ss);
            }
        }

        return ss;
    }
    public static Boolean isVailedList(String s){
        // 括弧で開始し括弧で終了 (list) か要素数 1 (atom)
        // 括弧がすべて対応する
        // 括弧で囲まれている = 対応数が、終了以外で 0 にならない
        String[] ss = s.split(" ");
        if(ss.length == 1){
            return !ss[0].equals("(") && !ss[0].equals(")");
        }
        int prth = 0;
        for(int i = 0; i < ss.length; i++){
            if (ss[i].equals("(")) prth = prth + 1;
            if (ss[i].equals(")")) prth = prth - 1;
            if (i != ss.length - 1 && prth == 0){
                Debug.p("isVailedList", "close-prth", prth);
                return false;
            }
        }
        Debug.p("isVailedList", "open-prth", prth);
        return prth == 0;
    }

    // public static ArrayList<String> toSexpression(String[] ss, int i){
    //     if(ss[i].equals("(")){
    //         ArrayList<String> se = new ArrayList<String>();
    //         se.add(toSexpression(ss, i + 1));
            
    //     }
    //     if(ss[i].equals(")")){

    //     }
    //     if(ss[i].equals("NIL")){
    //         return "NIL";
    //     }
    // }
}