import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = null;
        PrintWriter out = null;
        int id;
        String firstName;
        String lastName;

        try {
            in = new Scanner(Paths.get("FileIO/src/infile.txt"));
            out = new PrintWriter("/home/users/bostasze/Documents/outfile.txt");
            while (in.hasNext()) {
                id = in.nextInt();
                firstName = in.next();
                lastName = in.next();

                System.out.printf("loaded: id = %3d, name = %-12s, last name = %-13s \n", id, firstName, lastName);
                out.printf("%d, %s, %s \n", id, firstName, lastName);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }

}