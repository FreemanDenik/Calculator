package Helpers;
import java.util.HashMap;

public class Rome {
    public HashMap<String, Integer> Collect;

    public Rome() {
        Collect = new HashMap<>();
        Collect.put("I", 1);
        Collect.put("II", 2);
        Collect.put("III", 3);
        Collect.put("IV", 4);
        Collect.put("V", 5);
        Collect.put("VI", 6);
        Collect.put("VII", 7);
        Collect.put("VIII", 8);
        Collect.put("IX", 9);
        Collect.put("X", 10);

    }
    // Проверить римская цифра или нет
    public Boolean IsRome(String str){
       return Collect.get(str) != null;
    }
    // Преобразовать римскую цифру в арабскую
    public Integer ConvertRomeToInt(String str){
        return Collect.get(str);
    }
    // Проверить арабская цифра или нет
    public Boolean IsSimple(String str){
        try{
           int result = Integer.parseInt(str);
           return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    // Преобразовать (строку) цифру в арабскую
    public Integer ConvertSimpleToInt(String str){
        return  Integer.parseInt(str);
    }
}

