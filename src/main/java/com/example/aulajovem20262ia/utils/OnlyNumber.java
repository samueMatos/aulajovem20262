package com.example.aulajovem20262ia.utils;

public class OnlyNumber {

    public static String onlyNumber(String valor){

        return valor.replaceAll("\\D", "");
    }
}
