package com.example.datastructre.javalogics;

public class JavaEquals {

    public static void main(String[] args) {
        String s1 = "dipak";
        String s2= "dipak";
        String s3 = new String("dipak");

        String s4 = s1;

        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true

        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // true

        System.out.println(s1 == s4); // true
        System.out.println(s1.equals(s4)); // true


    }

}

