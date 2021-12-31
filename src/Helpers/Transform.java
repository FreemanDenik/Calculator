package Helpers;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transform {

    // Определитель математического знака
    private static String DetectZnak(String str){
        try {
            Pattern pat = Pattern.compile("[+*-/]");
            Matcher mat = pat.matcher(str);

            if (mat.find()) {
                return str.substring(mat.start(), mat.end());
            }else {
                throw new Exception("Нету математического знака! (+ - * /)");
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Разбивание строки на два числа и знак
    public static HashMap<String, Object> SplitStr(String str){
        HashMap<String, Object> result = new HashMap<>();
        Rome rome = new Rome();

        int firstOut;
        int secondOut;
        boolean isRome = false;
        String znak ;
        try {
            znak = DetectZnak(str);
            if(znak == null)
                return null;
            String[] arr = str.split("["+znak+"]");
            String firstArr = arr[0].trim();
            String secondArr = arr[1].trim();

            if (rome.IsRome(firstArr) && rome.IsRome(secondArr)) {
                firstOut = rome.ConvertRomeToInt(firstArr);
                secondOut = rome.ConvertRomeToInt(secondArr);
                isRome = true;
            } else if (rome.IsSimple(firstArr) && rome.IsSimple(secondArr)) {
                firstOut = rome.ConvertSimpleToInt(firstArr);
                secondOut = rome.ConvertSimpleToInt(secondArr);
            } else {
                throw new Exception("Цифры джолжны быть либо римскими либо арабскими");
            }
            if(firstOut > 10 || secondOut > 10)
                throw new Exception("Цифра должна быть не больше 10");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        result.put("first", firstOut);
        result.put("second", secondOut);
        result.put("znak", znak);
        result.put("isRome", isRome);
        return result;
    }
    public static String ConvertRome(Integer i){
        HashMap<Integer, String> Rome = new HashMap<>();
        Rome.put(1, "I");
        Rome.put(2, "II");
        Rome.put(3, "III");
        Rome.put(4, "IV");
        Rome.put(5, "V");
        Rome.put(6, "VI");
        Rome.put(7, "VII");
        Rome.put(8, "VIII");
        Rome.put(9, "IX");
        Rome.put(10, "X");
        Rome.put(20, "XX");
        Rome.put(30, "XXX");
        Rome.put(40, "XL");
        Rome.put(50, "L");
        Rome.put(60, "LX");
        Rome.put(70, "LXX");
        Rome.put(80, "LXXX");
        Rome.put(90, "XC");
        Rome.put(100, "C");
        String result = Rome.get(i);

        if(result == null){
            var XX = Integer.parseInt(i.toString().substring(0, 1) + "0");
            var XX1 = Integer.parseInt(i.toString().substring(1, 2));
            result = Rome.get(XX) + Rome.get(XX1);
        }

        return result;
    }
}
