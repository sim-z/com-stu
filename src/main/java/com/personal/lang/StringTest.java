package com.personal.lang;

public class StringTest {

    public static void main(String[] args) {
        
        String s = "abc123ABC";
        
//        System.out.println(s.equals("abc123abc"));
//        System.out.println(s.equalsIgnoreCase("abc123abc"));
//        System.out.println(s.contentEquals(new StringBuffer().append("abc123abc")));
    
        System.out.println(s.compareTo("123"));
    }

}
