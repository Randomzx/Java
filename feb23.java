public class feb23 {
    public static void main(String args[])
    {
        Programmer emp = new Programmer();
        // static method accessed using variable emp
        emp.accessBaseClassMembers();

        System.out.println(emp.name);
    }
}

class Employee {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected float experience;
}

class Programmer extends Employee {
    private String[] programmingLanguages;
    public void writeCode() {}
    public void accessBaseClassMembers() {
        name = "Programmer";
    }
}
