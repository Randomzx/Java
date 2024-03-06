package derived;

public class March5 {
}

// What happens if both a catch and a finally block define return statements?
// If both the catch and finally blocks define return statements,
// the calling method will receive a value from the finally block.
class MultipleReturn {
    int getInt() {
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]); // Throws ArrayIndexOutOfBoundsException
        } catch (Exception e) {
            return 10; // Returns value 10 from catch block
        } finally {
            return 20; // Returns value 20 from finally block
        }
    }

    public static void main(String args[]) {
        MultipleReturn var = new MultipleReturn();
        System.out.println(var.getInt());
    }
}


// What happens if a finally block modifies the value returned from a catch block?
// If a catch block returns a primitive data type, the finally block can’t modify the value being returned by it.
class MultipleReturn0 {
    int getInt() {
        int returnVal = 10;
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]); // Throws ArrayIndexOutOfBoundsException
        } catch (Exception e) {
            System.out.println("About to return :" + returnVal);
            return returnVal; // Returns value 10 from catch block
        } finally {
            returnVal += 10; // Modifies value of variable to be returned in finally block
            System.out.println("Return value is now :" + returnVal);
        }
        return returnVal;
    }
    public static void main(String args[]) {
        MultipleReturn0 var = new MultipleReturn0();
        System.out.println("In Main:" + var.getInt());
    }
}

//  if the method returns an object?
class MultipleReturn1 {
    StringBuilder getStringBuilder() {
        StringBuilder returnVal = new StringBuilder("10");
        try {
            String[] students = {"Harry", "Paul"};
            System.out.println(students[5]);
        } catch (Exception e) {
            System.out.println("About to return :" + returnVal);
            return returnVal; // Returns StringBuilder object value from catch block
        } finally {
            returnVal.append("10");
            System.out.println("Return value is now :" + returnVal);
        }
        return returnVal; // Modifies value of variable to be returned in finally block
    }
    public static void main(String args[]) {
        MultipleReturn1 var = new MultipleReturn1();
        System.out.println("In Main:" + var.getStringBuilder());
    }
}