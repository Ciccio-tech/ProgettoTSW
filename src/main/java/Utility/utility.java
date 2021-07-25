package Utility;

import java.util.Base64;

public class utility {

    public static String encode(String s){
        byte[] encodeBytes = Base64.getEncoder().encode(s.getBytes());
        return new String(encodeBytes);
    }

    public static String decode(String s){
        byte[] encodeBytes = Base64.getDecoder().decode(s.getBytes());
        return new String(encodeBytes);
    }

}
