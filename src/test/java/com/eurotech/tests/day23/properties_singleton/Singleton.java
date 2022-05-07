package com.eurotech.tests.day23.properties_singleton;

public class Singleton {

    // private constructor olusturduk

    private Singleton(){};

    private static String str;

    public static String getInstance(){

        if (str==null){
            System.out.println("str is null, assigning a value to it");
            str="chrome browser";
        }else {
            System.out.println("str has a value, just returning it");
        }

        return str;
    }



}
