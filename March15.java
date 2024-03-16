package derived;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Predicate;

public class March15 {


}

class LoginAttempt {
    static void login(String username, String pwd, int maxLoginAttempt)
    {
        if (username == null || username.length() < 6)
            throw new IllegalArgumentException
                    ("Login:username can’t be shorter than 6 chars");
        if (pwd == null || pwd.length() < 8)
            throw new IllegalArgumentException
                    ("Login: pwd cannot be shorter than 8 chars");
        if (maxLoginAttempt < 0)
            throw new IllegalArgumentException
                    ("Login: Invalid loginattempt val");
    }

    public static void main(String args[])  throws IOException
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Scanner in = new Scanner(System.in);

        System.out.print("Enter username (string): ");
        String username = in.nextLine();
        System.out.println("username: " + username);

        System.out.print("Enter password (string): ");
        String pwd = in.nextLine();
        System.out.println("password: " + pwd);

        System.out.print("Enter max login number (int): ");
        int maxLoginAttempt = in.nextInt();
        System.out.println("max login: " + maxLoginAttempt);
        login(username, pwd, maxLoginAttempt);

    }
}

class whichWillCompile {
    // Compiles successfully. Because IllegalArgumentException is a runtime exception,
    // method1() can throw it without declaring it to be thrown in its throws statement
    private void method1(String name) {
        if (name.equals("star"))
            throw new IllegalArgumentException(name);
    }

    // Won’t compile. method2() throws a checked exception, that is,
    // Exception, without declaring it to be thrown in its throws statement.
    private void method2(int age) {
        if (age > 30) {
            //throw Exception();
        }
    }

    // Compile successfully. A method can throw a StackOverflowError (an unchecked exception) without includ-
    // ing it in the throws clause of its method declaration
    public Object method3(boolean accept) {
        if (accept)
            throw new StackOverflowError();
        else
            return new StackOverflowError();
    }

    // Won’t compile. If a method declares to throw a checked exception,
    // its body can’t throw a more general exception in its body. method4() declares to
    // throw Exception but throws Throwable, which is not allowed (Exception subclasses Throwable)
    protected double method4() throws Exception {
        //throw new Throwable();
        return 0;
    }

    // Code will compile successfully. If a method declares to throw Exception,
    // it might not actually throw it. This only applies to Exception (because Runtime-
    // Exception subclasses it), runtime exceptions, and errors.
    public double method5() throws Exception {
        return 0.7;
    }
}

// Create a try-catch block and determine how exceptions alter normal program flow
class programFlow {
    public static void main(String[] args) {
        int a = 10; String name = null;


        try {
            a = name.length(); // Null-PointerException thrown
            // When an exception is thrown, the control is transferred to the exception handler,
            //skipping the execution of the remaining lines of code in the try block. So (a++) doesn’t execute
            a++;
        } catch (NullPointerException e){
            // The code defines an exception handler for both NullPointerException and
            // RuntimeException. When an exception is thrown, ==more than one exception handler
            // won’t execute==. In this case, the exception handler for NullPointerException will execute
            // because it’s more specific and it’s defined earlier than RuntimeException.
            ++a;
            return;
        } catch (RuntimeException e){
            a--;
            return;
        } finally {
            System.out.println(a);
        }
    }
}

// Differentiate between object reference variables and primitive variables
interface Moveable {
    int move(int distance);
}

// The instance variables of a class are all assigned default values if no explicit value is assigned to them
class Person {
    static int MIN_DISTANCE = 5;
    int age; // byte, short, int -> 0
    float height; // 0.0f
    boolean result; // boolean -> false
    String name; // objects -> null
}
class LamdbaExpression {
    public static void main(String arguments[]) {
        Person person = new Person();
        // defines the code to execute for its functional method move by using the Lambda expression (x) -> Person.MIN _DISTANCE + x.
        Moveable moveable = (x) -> Person.MIN_DISTANCE + x;
        // Calling moveable.move(20) passes 20 as an argument to the method move. It returns 25
        // (the sum of Person.MIN_DISTANCE, which is 5, and the method argument 20)
        System.out.println(person.name + person.height + person.result
                + person.age + moveable.move(20));
        // output: null0.0false025
    }
}

// Determine when casting is necessary
class Printer {
    int inkLevel;
}
class LaserPrinter extends Printer {
    int pagesPerMin;
    public static void main(String args[]) {
        Printer myPrinter = new LaserPrinter();
        System.out.println(/* INSERT CODE HERE */);
    }

    // a (LaserPrinter)myPrinter.pagesPerMin
        // incorrect because (LaserPrinter) tries to cast myPrinter.pagesPerMin (variable of primitive type int) to LaserPrinter
        // This code won’t compile
    // b myPrinter.pagesPerMin
        // Incorrect. The type of reference variable myPrinter is Printer.
        // myPrinter refers to an object of the class LaserPrinter, which extends the class Printer.
        // A reference variable of the base class can’t access the variables and methods
        // defined in its subclass without an explicit cast.
    // c LaserPrinter.myPrinter.pagesPerMin
        // Incorrect. LaserPrinter.myPrinter treats LaserPrinter as a variable,
        // although no variable with this name exists in the question’s code. This code fails to compile.
    // d ((LaserPrinter)myPrinter).pagesPerMin
        // Correct
}

// What is the output of the following code?
class MyCalendar {
    public static void main(String arguments[]) {

        Season season1 = new Season();
        season1.name = "Spring";
        Season season2 = new Season();
        season2.name = "Autumn";

        // Lambda expression is trying to return a String value and so the code fails compilation
        // Predicate<String> aSeason = (s) -> s == "Summer" ? season1.name : season2.name;


        // multiple variable references can refer to the same instances.
        // Predicate<String> aSeason = (s) -> s == "Summer";

        season1 = season2; //  reinitializes the reference variable season1 and assigns it to the object referred to by the variable season2

        // Now the variable season1 refers to the object that’s also referred to by the variable
        // season2. Both of these variables refer to the same object—the one that has the value
        // of the instance variable set to Autumn.
        System.out.println(season1.name);
        System.out.println(season2.name);
        //System.out.println(aSeason.test(new String("Summer")));

        // output:
        // Autumn
        // Autumn
        // false

    }
}
class Season {
    String name;
}








