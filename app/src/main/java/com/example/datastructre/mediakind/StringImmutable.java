package com.example.datastructre.mediakind;

/**
 * Created by Dipak Kumar Mehta on 11/17/2022.
 */
public class StringImmutable {

    public static void main(String[] args) {

        String s1="xyz";
        String s2="xyz";
        String s3=new String(s1);
        String s4=new String(s2);

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));

    }
}
