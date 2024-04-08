package derived;
import java.io.FileNotFoundException;
public class March3 {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Binding of variables and methods");
        Employee emp = new Employee();
        Employee programmer = new Programmer();
        System.out.println(emp.name);
        System.out.println(programmer.name);
        emp.printName();
        programmer.printName();

        System.out.println("\nPOLYMORPHISM WITH ABSTRACT METHODS");
        MobileAppExpert expert1 = new Programmer0();
        MobileAppExpert expert2 = new Manager0();
        expert1.deliverMobileApp();
        expert2.deliverMobileApp();


        Base base = new Base();
        Base derived = new Derived();
        System.out.println("Base");
        base.printVar();
        System.out.println(base.var);
        System.out.println("derived");

        System.out.println(derived.var + "from derived.var");

        derived.printVar();


    }
}

class Employee {
    String name = "Employee";
    void printName() {
        System.out.println(name);
    }
}
class Programmer extends Employee {
    String name = "Programmer";
    void printName() {
        System.out.println(name);
    }
}


class Employee0 {
// code

}
interface MobileAppExpert {
    void deliverMobileApp();

}
class Programmer0 extends Employee0 implements MobileAppExpert {
    public void deliverMobileApp() {
        System.out.println("testing complete on real device");
    }
}
class Manager0 extends Employee0 implements MobileAppExpert {
    public void deliverMobileApp() {
        System.out.println("QA complete");
        System.out.println("code delivered with release notes");
    }
}


class Base {
    String var = "Base Java";
    void printVar() {
        System.out.println(var);
    }
}
class Derived extends Base {
    String var = "Guru";
    void printVar() {
        System.out.println(var);
    }
}

class Trace {
    public static void main(String args[]) {
        method1();
    }
    public static void method1() {
        method2();
    }
    public static void method2() {
        String[] students = {"Shreya", "Joseph"};
        System.out.println(students[5]);
    }
}
