package derived;

import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class March9 {

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


// nested try catch
 class NestedTryCatch {
    FileInputStream players, coach;
    public void myMethod() {
        try {
            players = new FileInputStream("players.txt");
            try {
                coach = new FileInputStream("coach.txt");

            } catch (FileNotFoundException e) {
                System.out.println("coach.txt not found");
            }

        }
        catch (FileNotFoundException fnfe) {
            System.out.println("players.txt not found");
        }
        finally {
            try {
                players.close();
                coach.close();
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
    }
}

// players.txt found
// NullPointerException
class TwistInTaleNestedTryCatch {
    static FileInputStream players, coach;
    public static void main(String args[]) {
        try {
            players = new FileInputStream("D:\\Yu\\FreeCodeCamp\\Test\\src\\main\\java\\derived\\players.txt");
            System.out.println("players.txt found");
            try {
                coach.close();
            } catch (IOException e) {
                System.out.println("coach.txt not found");
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("players.txt not found");
        } catch (NullPointerException ne) {
            System.out.println("NullPointerException");
        }
    }
}

// throws class exception
class ListAccess {
    public static void main(String args[]) {
        ArrayList<Ink> inks = new ArrayList<Ink>();
        inks.add(new ColorInk());
        inks.add(new BlackInk());
        Ink ink = (BlackInk)inks.get(0);
    }
}
class Ink{}
class ColorInk extends Ink{}
class BlackInk extends Ink{}


// the instanceof operator to verify whether an object can be cast to another class before casting it.
class AvoidClassCastException {
    public static void main(String args[]) {
        ArrayList<Ink> inks = new ArrayList<Ink>();
        inks.add(new ColorInk());
        inks.add(new BlackInk());
        if (inks.get(0) instanceof BlackInk) {
            BlackInk ink = (BlackInk)inks.get(0); // No ClassCastException
        }
    }
}


