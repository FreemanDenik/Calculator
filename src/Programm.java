
import Helpers.*;

import java.util.Scanner;

public class Programm {
    public static void main(String[] args) {
        while (true) {
            var str = new Scanner(System.in).nextLine();
            var arr = Transform.SplitStr(str);
            var res = arr != null ? Calculate.Go(arr) : null;


            if(res != null)
                System.out.println(res);
        }
    }
}
