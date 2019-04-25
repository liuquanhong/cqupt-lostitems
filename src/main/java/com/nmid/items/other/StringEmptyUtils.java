package com.nmid.items.other;

public class StringEmptyUtils {

    public static boolean ValidStringEmpty(String str){
        if(str == null || str.length() == 0 || str.trim().isEmpty())
            return false;
        return true;
    }
}
