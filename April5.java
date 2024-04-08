package derived;

public class April5 {
}


class april{

    public static void main(String args[]) {

    }
}

// variable arguments (varargs)
class Employee {
    public int daysOffWork(int... days) {
        int daysOff = 0;
        for (int i = 0; i < days.length; i++)
            daysOff += days[i];
        return daysOff;
    }
}
//The ellipsis (...) that follows the data type indicates that the method parameter days may be passed
// an array or multiple comma-separated values. Reexamine the preceding code example and note the usage
// of the variable days in the method daysOff- Work—it works like an array.
// When you define a variable-length argument for a method, Java creates an array behind the scenes to implement it
//You can define only one variable argument in a parameter list, and it must be the last variable in the parameter list.
// If you don’t comply with these two rules, your code won’t compile.
class Employee0 {
    public int daysOffWork(String... months, int... days) {
        int daysOff = 0;
        for (int i = 0; i < days.length; i++)
            daysOff += days[i];
        return daysOff;
    }
}

//If your method defines multiple method parameters, the variable that accepts variable arguments must be the
// last one in the parameter list
class Employee1 {
    public int daysOffWork(int... days, String year) {
        int daysOff = 0;
        for (int i = 0; i < days.length; i++)
            daysOff += days[i];
        return daysOff;
    }
}



// GARBAGE COLLECTING REFERENCED OBJECTS
// The garbage collector can also reclaim memory from a group of referenced objects.
// This group of variables is referred to as an island of isolation. An instance can be referred to by multiple variables.
// So when you assign null to one of these variables, the instances can still be referenced using other variable(s).
// But a group of instances with no external reference becomes eligible for garbage collection.

class Exam {
    private String name;
    private Exam other;
    public Exam(String name)
    {
        this.name = name;
    }
    public void setExam(Exam exam)
    {
        other = exam;
    }
}
class IslandOfIsolation {
    public static void main(String args[])
    {

        // two variables, php and java, are created and initialized using Exam instances.
        Exam php = new Exam("PHP");
        Exam java = new Exam("Java");

        // java is assigned to php.other
        php.setExam(java);     // Assign object referred by java to php.exam
        // php is assigned to java.other.
        java.setExam(php);     // Assign object referred by php to java.exam

        // when php is set to null, the instance referred to by it isn’t eligible for garbage collection because
        // it can still be referenced using java.other.
        php = null;
        // when java is also set to null, both the objects referred to by java and php become eligible for garbage collection.
        // Even though both these objects can be referred to by each other, they can no longer be referenced in the method main.
        // They form an island of isolation. Java’s garbage collector can determine such groups of instances.
        java = null; // A group of instances with no external references forms an island of isolation,
                     // which is eligible for garbage collection.
    }
}


