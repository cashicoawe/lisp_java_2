package pkg;
import java.util.*;
import java.io.*;

public class Result {
    public Boolean error;
    public String body;
    public ArrayList<String> message;

    Result(Boolean e, String b, String m){
        error = e;
        body = b;
        message = new ArrayList<String>(m);
    }
}