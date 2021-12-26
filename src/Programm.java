import java.util.ArrayList;
import Helpers.*;
import java.util.Scanner;

public class Programm {
    public static void main(String[] args){

        var str = new Scanner(System.in).nextLine();
        var arr = Transform.SplitStr(str);
        var res = Calculate.Go(arr);

        System.out.println(res);
    }
}
