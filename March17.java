package derived;

public class March17 {
}


// Given the following definition of the classes Animal, Lion, and Jumpable,
// select the correct combinations of assignments of a variable that don’t result in compi-
// lation errors or runtime exceptions (select 2 options)
interface Jumpable {}
class Animal {}
class Lion extends Animal implements Jumpable {}
    // a Jumpable var1 = new Jumpable();
        // incorrect. An interface can’t be instantiated.
    // b Animal var2 = new Animal();
        // correct
    // c Lion var3 = new Animal();
        // incorrect. A reference variable of a derived class can’t be used to refer to an object of its base class.
    // d Jumpable var4 = new Animal();
        // incorrect. A reference variable of type Jumpable can’t be used to refer to an object of the class Animal
            // because Animal doesn’t implement the interface Jumpable
    // e Jumpable var5 = new Lion();
        // correct
    // f Jumpable var6 = (Jumpable)(new Animal())
        // is incorrect. Although this line of code will compile successfully,
        // it will throw a ClassCastException at runtime.
        // You can explicitly cast any object to an interface, even if it doesn’t implement it to make the code compile.
        // But if the object’s class doesn’t implement the interface, the code will throw a ClassCastException at runtime.


// what is the output of the following code?
class Student { int marks = 10; }
class Result {
    public static void main(String... args) {
        Student s = new Student();
        switch (s.marks) {
            default: System.out.println("100");
            case 10: System.out.println("10");
            case 98: System.out.println("98");
        }
    }
}
// ans: 10
//      98
// The default case executes only if no matching values are found.
// Because a break statement doesn’t terminate this case label,
// the code execution continues and executes the remaining statements within the switch block,
// until a break statement terminates it or it ends.

class Doctor {
    protected int age;
    protected void setAge(int val) { age = val; }
    protected int getAge() { return age; }
}
class Surgeon extends Doctor {
    Surgeon(String val) {
        specialization = val;
    }
    String specialization;
    String getSpecialization() { return specialization; }
}
//Given the following statements,
    // com.ejava is a package
        // class Person is defined in package com.ejava
        // class Course is defined in package com.ejava
// which of the following options correctly import the classes Person and Course in the class MyEJava?

    // a    import com.ejava.*;
    //      class MyEJava {}
    /* correct. The statement import com.ejava.*; imports all the public members of the package com.ejava in the class MyEJava.*/

    // b    import com.ejava;
    //      class MyEJava {}
    /* incorrect. Because com.ejava is a package, to import all the classes defined in this package,
     the package name should be followed by .*: import com.ejava.*; */

    // c    import com.ejava.Person;
    //      import com.ejava.Course;
    //      class MyEJava {}
    /* correct. It uses two separate import statements to import each of the classes Person and Course individually, which is correct.*/

    // d    import com.ejava.Person;
    //      import com.ejava.*;
    //      class MyEJava {}
    /* correct. The first import statement imports only the class Person in MyClass.
    But the second import statement imports both the Person and Course classes from the package com.ejava.
    You can import the same class more than once in a Java class with no issues.*/

// ans: a, c, d
/*
In Java, the import statement makes the imported class visible to the Java compiler,
allowing it to be referred to by the class that’s importing it.
In Java, the import statement doesn’t embed the imported class in the target class.
 */


//Select the most appropriate definition of the variable name and the
// line number on which it should be declared so that the following code compiles successfully.
class EJavaLine {
    // LINE 1
    // The variable name must be accessible in the instance method [calc], the
    // class constructor, and the static method main. A non-static variable can’t be
    // accessed by a static method. Hence, the only appropriate option is to define a
    // static variable name that can be accessed by all: the constructor of the class EJava
    // and the methods calc and main.
    static String name; // answer

    public EJavaLine() {
        System.out.println(name);
    }
    void calc() {
// LINE 2
        if (8 > 2) {
            System.out.println(name);
        }
    }
    public static void main(String... args) {
// LINE 3
        System.out.println(name);
    }
}


// what is the correct statement about the code?
class Emp {
    Emp mgr = new Emp();
}
class Office {
    public static void main(String args[]) {
        Emp e = null;
        e = new Emp(); // The code throws a runtime exception and the code execution never reaches below this line
        e = null;
    }
}
// The code throws java.lang.StackOverflowError at runtime. [e = new Emp()] creates an instance of class Emp.
// Creation of an object of the class Emp requires the creation of an instance variable mgr
// and its initialization with an object of the same class.
// The Emp object creation calls itself recursively (without an exit condition), resulting in a java.lang.StackOverflowError.



/*
Assume that Oracle has asked you to create a method that returns the concatenated value of two String objects.
Which of the following methods can accomplish this job? (Select 2 options.)
 */
// answer: b, d
/*
    a) incorrect.
        This method defines method parameters with invalid identifier names.
        Identifiers can’t start with a digit.
    public String add(String 1, String 2) {
        return str1 + str2;
    }

    b) correct.
        The method requirements don’t talk about the access modifier of the required method.
        It can have any accessibility.
    private String add(String s1, String s2) {
        return s1.concat(s2);
    }

    c) incorrect because the class String doesn’t define any append method.
    protected String add(String value1, String value2) {
        return value2.append(value2);
    }

    d) correct.
        Even though the name of the method—subtract—isn’t an appropriate name
        for a method that tries to concatenate two values, it does accomplish the required job.
    String subtract(String first, String second) {
        return first.concat(second.substring(0));
    }
 */

// Option (a) is
//Option (b) is
//Option (c) is
//Option (d) is

// What is true about the following code? (Select 1 option.)

class Shoe {}
class Boot extends Shoe {}
class ShoeFactory {
    ShoeFactory(Boot val) {
        System.out.println("boot");
    }
    ShoeFactory(Shoe val) {
        System.out.println("shoe");
    }
}

// a The class ShoeFactory has a total of two overloaded constructors.
    // Correct: Java accepts changes in the objects of base-derived classes as a sole criterion to define overloaded constructors and methods.
// b The class ShoeFactory has three overloaded constructors, two user-defined constructors, and one default constructor.
    // incorrect because Java doesn’t generate a default constructor for a class that has already defined a constructor.
// c The class ShoeFactory will fail to compile.
    // incorrect. All classes defined for this example compile successfully.
// d The addition of the following constructor will increment the number of constructors of the class ShoeFactory to 3:
        // ShoeFactory (Shoe arg) {}
    // Incorrect. The class ShoeFactory already defines a constructor that accepts a method argument of type Shoe.
    // You can’t overload a constructor with a mere change in its access modifier.
