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
        Integer first;
        Integer second;
        String znak ;
        try {
            znak = DetectZnak(str);
            if(znak == null)
                return null;
            String[] arr = str.split("["+znak+"]");
            if (rome.IsRome(arr[0]) && rome.IsRome(arr[1])) {
                first = rome.ConvertRomeToInt(arr[0]);
                second = rome.ConvertRomeToInt(arr[1]);
            } else if (rome.IsSimple(arr[0]) && rome.IsSimple(arr[1])) {
                first = rome.ConvertSimpleToInt(arr[0]);
                second = rome.ConvertSimpleToInt(arr[1]);
            } else {
                throw new Exception("Цифры джолжны быть либо римскими либо арабскими");
            }
            if(first > 10 || second > 10)
                throw new Exception("Цифра должна быть не больше 10");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        result.put("first", first);
        result.put("second", second);
        result.put("znak", znak);
        return result;
    }
}
