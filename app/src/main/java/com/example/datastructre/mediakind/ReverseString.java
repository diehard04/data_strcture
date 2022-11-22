package com.example.datastructre.mediakind;

/**
 * Created by Dipak Kumar Mehta on 11/17/2022.
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ReverseString hw = new ReverseString();
        System.out.println(hw.reverse("121"));
    }

    boolean reverse(String value) {
        StringBuffer result = new StringBuffer("");
        for (int i = (value.length() - 1); i >= 0; i--) {
            result.append(value.charAt(i));
        }

        if (value.equals(result.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
