package com.example.infotep.Utils;

public class UUID {
    public static String generate(){
        String result = java.util.UUID.randomUUID().toString();
        result.replaceAll("-", "");
        result.substring(0, 32);
        return result;
    }
}
