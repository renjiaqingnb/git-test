package com.rjq;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        String c = new String(a + b);
        String d = "3";
        String g = "3";
        String h = "12";
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(c == d);
        System.out.println(d == g);
        System.out.println(g.hashCode());
        System.out.println(c == h);
    }
}
