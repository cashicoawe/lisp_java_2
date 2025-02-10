import java.util.*;
import java.io.*;
import pkg.*;

public class Entry{
    public static void main(String[] args){
        try {
            Debug.on = true;
            Debug.flags.add("hello");
            // Debug.p("hello", "title", "body");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}