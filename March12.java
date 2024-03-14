package derived;

import java.util.ArrayList;

public class March12 {
}

// Stack overflow
class StackOverflowError0{
    static void recursion() {
        recursion();
    }
    public static void main(String args[]) {
        recursion();
    }
}



// JVM handles the error
class EJava {
    void method() {
        try {
            guru();
            return; // supposed to end the execution of the method method.
        } finally {
            System.out.println("finally 1");
        }
    }
    void guru() {
        System.out.println("guru");
        throw new StackOverflowError(); // not a checked exception
    }
    public static void main(String args[]) {
        EJava var = new EJava();
        var.method();
    }
}

//  try block can be followed by a finally block without any catch blocks.
class TryFinally {
    int tryAgain() {
        int a = 10;
        try {
            ++a;
        } finally {
            a++;
        }
        return a;
    }
    public static void main(String args[]) {
        System.out.println(new TryFinally().tryAgain());
    }
}

// ClassCastException
class ListAccess {
    public static void main(String args[]) {
        ArrayList<Ink> inks = new ArrayList<Ink>();
        inks.add(new ColorInk());
        inks.add(new BlackInk());
        //if (inks.get(0) instanceof BlackInk) { // the instanceof operator can verify whether an object can be cast to another class
        Ink ink = (BlackInk)inks.get(0); // tries to cast an object of ColorInk to BlackInk.
        //}
    }
}
class Ink{}
class ColorInk extends Ink{}
class BlackInk extends Ink{}