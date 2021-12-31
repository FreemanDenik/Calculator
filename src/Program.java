
import Helpers.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        while (true) {
            // Получаем строку
            var str = new Scanner(System.in).nextLine();
            // Проверяем и разделяем на два числа и математический знак
            var arr = Transform.SplitStr(str);
            // Производим математическую операцию
            var res = arr != null ? Calculate.Go(arr) : null;

            // Выводи или не выводим ответ
            if(res != null)
                if((Boolean) arr.get("isRome"))
                    System.out.println(Transform.ConvertRome(res));
                else
                    System.out.println(res);
        }
    }
}
