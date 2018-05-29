package com.cc.mediacentre.utils;

import java.io.File;
import java.util.Calendar;
import java.util.regex.Pattern;

public class CommonUtils {

    public static String getDatePath() {
        StringBuffer sb = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = calendar.get(Calendar.MONTH);
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        sb.append(year);
        sb.append("/");
        sb.append((month + 1));
        sb.append("/");
        sb.append(day);
        sb.append("/");
        return sb.toString();
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        System.out.println(getDatePath());
        System.out.println(isNumeric("a"));

        File file = new File("D:/note/gitssh.txt");

        System.out.println(file.length());

    }
}
