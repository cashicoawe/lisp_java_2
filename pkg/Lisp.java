package pkg;
import java.util.*;
import java.io.*;

public class Lisp {
    public static String format(String s){
        return s
        .replaceAll("\\(", " ( ")
        .replaceAll("\\)", " ) ")
        .replaceAll("\n", " ")
        .replaceAll("\t", " ")
        .replaceAll(" {2,}", " ")
        .trim();
    }
    public static Boolean isVailedList(String s){
        // 括弧で開始し括弧で終了 (list) か要素数 1 (atom)
        // 括弧がすべて対応する
        // 括弧で囲まれている = 対応数が、終了以外で 0 にならない
        String[] ss = s.split(" ");
        Debug.p("isVailedList", "ss", Arrays.toString(ss));
        Debug.p("isVailedList", "ss_length", Integer.toString(ss.length));
        if(ss.length == 1){
            return !ss[0].equals("(") && !ss[0].equals(")");
        }
        // if(ss[0] != "(") return false;
        // if(ss[ss.length - 1] != ")") return false;
        int prth = 0;
        for(int i = 0; i < ss.length - 1; i++){
            if (ss[i].equals("(")) {prth = prth + 1;}
            if (ss[i].equals(")")) prth = prth - 1;
            // Debug.p("isVailedList", "prth", (ss[i] == "("));
            if (i != ss.length - 1 && prth == 0){
                return false;
            }
        }
        return true;
    }
    static String toSExpression(String s){
        return "";
    }
}