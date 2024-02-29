package Java;

public class Feb28 {

    public static void main(String args[])
    {
        HRExecutive0 hr = new HRExecutive0(); // A variable of type HRExecutive0 can be used to refer to its object
        hr.specialization = new String[] {"Staffing"}; // Access variable defined in class HRExecutive0
        System.out.println(hr.specialization[0]);
        hr.name = "Pavni Gupta"; // Access variable defined in class Employee0
        System.out.println(hr.name);
        hr.conductInterview(); //Access method defined in interface Interviewer0


        Employee0 emp = new HRExecutive0(); // Variable of type Employee can also be used to refer to an object of class HRExecutive because class HRExecutive extends Employe
        //emp.specialization = new String[] {"Staffing"}; // Variable emp can’t access member specialization defined in class HRExecutive
        //System.out.println(emp.specialization[0]);
        emp.name = "Pavni Gupta";  // Variable emp can access member name defined in class Employee
        //System.out.println(emp.name);
        //emp.conductInterview();  // Variable emp can’t access method conductInterview defined in interface Interviewer

        Interviewer0 interviewer0 = new HRExecutive0();  //Type of variable interviewer is Interviewe
        //interviewer0.specialization = new String[] {"Staffing"}; // Variable interviewer can’t access members of class Employee or HRExecutive
        //System.out.println(interviewer.specialization[0]);
        //interviewer0.name = "Pavni Gupta";
        //System.out.println(interviewer0.name);
        interviewer0.conductInterview(); // Variable interviewer can access method conductInterview defined in interface Interviewer

        Interviewer0[] interviewers = new Interviewer0[2]; // Array of type Interviewer— an interface
        interviewers[0] = new Manager0(); // Because Manager implements interface Interviewer, it can be stored here
        interviewers[1] = new HRExecutive0(); // Because HRExecutive implements interface Interviewer, it can be stored here
        // Loop through the array and call method conductInterview
        for (Interviewer0 interviewer : interviewers) {
            interviewer.conductInterview();
        }


        Interviewer interviewer = new HRExecutive();
        ((HRExecutive)interviewer).specialization = new String[] {"Staffing"};
    }
}

class Employee0 {
    String name;
    String address;
    String phoneNumber;
    float experience;
}

interface Interviewer0 {
    public void conductInterview();
}

// Class HRExecutive inherits class Employee and implements interface Interview
class HRExecutive0 extends Employee0 implements Interviewer0 {
    String[] specialization;
    public void conductInterview() {
        System.out.println("HRExecutive - conducting interview");
    }
}

class Manager0 implements Interviewer0 {

    int teamSize;
    public void conductInterview() {
        System.out.println("Manager - conducting interview");
    }
}


class Employee {}
interface Interviewer {
    public void conductInterview();
}
class HRExecutive extends Employee implements Interviewer {
    String[] specialization;
    public void conductInterview() {
        System.out.println("HRExecutive - conducting interview");
    }
}
class Manager implements Interviewer{
    int teamSize;
    public void conductInterview() {
        System.out.println("Manager - conducting interview");
    }
}

class OfficeWhyCasting {
    public static void main(String args[]) {
        // Array to store objects of classes that implement interface Interviewer
        Interviewer[] interviewers = new Interviewer[2];
        // Store object of Manager at array position 0
        interviewers[0] = new Manager();
        // Store object of HRExecutive at array position 1
        interviewers[1] = new HRExecutive();
        // Loop through values of array interviewers
        for (Interviewer interviewer : interviewers) {
            // If object referred to by interviewer is of class Manager, use casting to retrieve value for its teamSize
            if (interviewer instanceof Manager) {
                int teamSize =((Manager)interviewer).teamSize;
                // If interviewer’s teamSize > 10, call conductInterview
                if (teamSize > 10) {
                    interviewer.conductInterview();
                } else {
                    // If interviewer’s teamSize <= 10, print message
                    System.out.println("Mgr can't " +
                            "interview with team size less than 10");
                }
            // Otherwise, if object stored is of class HRExecutive,
                // call conductInterview method on object; no casting is required in this case
            } else if (interviewer instanceof HRExecutive) {
                interviewer.conductInterview();
            }
        }
    }
}


// this reference is required only when code executing within a method block needs to differentiate
// between an instance variable and its local variable or method parameters.
