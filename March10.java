package derived;
import java.util.ArrayList;
public class March10 {
}

// Null Point Exception
class ThrowNullPointerException {
    static ArrayList<String> list = null;
    public static void main(String[] args) {
        list.add("1");
    }
}

class ThrowNullPointerException1 {
    static ArrayList<String> list;
    public static void main(String[] args) {
        if (list!=null)
            list.add("1");
    }
}

class ThrowArithmeticEx {
    public static void main(String args[]) {
        int a = 10;
        int y = a++;
        int z = y--;
        int x1 = a - 2*y - z;
        int x2 = a - 11;
        int x = x1/ x2;
        System.out.println(x);
    }
}

class DivideDecimalNumberByZero {
    public static void main(String args[]) {
        // divide by zero
        System.out.println(77.0/0);

        // output NaN
        System.out.println(0.0/0);
    }
}

class ThrowNumberFormatException {
    public static int convertToNum(String val) {
        int num = 0;
        try {
            num = Integer.parseInt(val, 16);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(val+
                    " cannot be converted to hexadecimal number");
        }
        return num;
    }
    public static void main(String args[]) {
        System.out.println(convertToNum("16b"));
        System.out.println(convertToNum("65v"));
    }
}
