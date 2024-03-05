package derived;

import java.io.FileNotFoundException;

public class March4 {
    public static void main(String[] args) throws FileNotFoundException {

        DemoThrowsException test = new DemoThrowsException();
        test.readFile("one");

        RiverRafting riverRafting = new RiverRafting();
        try {
            riverRafting.crossRapid(11);
            // riverRafting.crossRapid(7);
            riverRafting.rowRaft("happy");
            System.out.println("Enjoy River Rafting");
        }
        catch (FallInRiverException e1) {
            System.out.println("Get back in the raft");
        }
        catch (DropOarException e2) {
            System.out.println("Do not panic");
        }
        finally {
            System.out.println("Pay for the sport");
        }
        System.out.println("After the try block");
    }
}

class DemoThrowsException {
    public void readFile(String file) throws NullPointerException, FileNotFoundException {
        if (file == null)
            throw new NullPointerException();
        boolean found = findFile(file);
        if (!found)
            throw new FileNotFoundException("Missing file");
        else {
            //code to read file
            System.out.println("printed");
        }
    }
    boolean findFile(String file) {
        //code to return true if file can be located
        if (file == "one")
        {
            return true;
        } else {
            return false;
        }
    }
}

class FallInRiverException extends Exception {
}
class DropOarException extends Exception {}

class RiverRafting {
    void crossRapid(int degree) throws FallInRiverException {
        System.out.println("Cross Rapid");
        if (degree > 10) throw new FallInRiverException();
    }
    void rowRaft(String state) throws DropOarException {
        System.out.println("Row Raft");
        if (state.equals("nervous")) throw new DropOarException();
    }
}

