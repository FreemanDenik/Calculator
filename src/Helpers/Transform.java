package Helpers;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transform {

    // Определитель математического знака
    private static String DetectZnak(String str){
        Pattern pat = Pattern.compile("[+*-/]");
        Matcher mat = pat.matcher(str);

        if(mat.find()) {
            return str.substring(mat.start(), mat.end());
        }

        return null;
    }
    // Разбивание строки на два числа и знак
    public static HashMap<String, Object> SplitStr(String str){
        HashMap<String, Object> result = new HashMap<>();
        Rome rome = new Rome();
        String znak = DetectZnak(str);
        String[] arr = str.split("["+znak+"]");
        Integer first;
        Integer second;
        if(rome.IsRome(arr[0])  && rome.IsRome(arr[1]) ) {
            first = rome.ConvertRomeToInt(arr[0]);
            second = rome.ConvertRomeToInt(arr[1]);
        }else if(rome.IsSimple(arr[0]) && rome.IsSimple(arr[1])) {
            first = rome.ConvertSimpleToInt(arr[0]);
            second = rome.ConvertSimpleToInt(arr[1]);
        }
        else {
            return null;
        }
        result.put("first", first);
        result.put("second", second);
        result.put("znak", znak);
        return result;
    }
}
